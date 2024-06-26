/* gavilan.blog anatomy-of-an-http-request */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class HttpServerApp {
    public static void main(String[] args) throws Exception{
        var serverSocket = new ServerSocket(8080);


        while(true){
            var connection  = serverSocket.accept();
            var request     = readRequest(connection);            

            printRequest(request);
            //System.out.println("We have a request ... "+ request);
            try(var os = connection.getOutputStream()){
                    var body = """
                         {
                         "id":"hello world"
                          }
                        """;

                    var response = """
                                    HTTP/1.1 200 OK
                                    Content-Type: application/json
                                    Content-Length: %d

                                    %s
                                   """.formatted(body.getBytes(StandardCharsets.UTF_8).length, body);

                    os.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

private static  HttpReq readRequest(Socket connection) throws Exception {
    try{
        var r  = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        var line = r.readLine();
        //System.out.println("Request line = "+ line);
        var methodUrl =  line.split(" ");
        var method = methodUrl[0];
        var url =  methodUrl[1];

        var headers = readHeaders(r);

       // var body = readBody(connection.getInputStream());

        return new HttpReq(method, url, headers, null);//Map.of(headers),null);
    }finally{
        System.out.println("Finally");
    }
}
/*private static byte[] readBody(InputStream stream){

}*/
private static void printRequest(HttpReq req){

    System.out.println("Method : " + req.method);
    System.out.println("Url : " + req.url);
    System.out.println("Headers : ");
    req.headers.forEach((k,v)-> {
        System.out.println("%s - %s".formatted(k,v));
    });
    
}
private static Map<String, List<String>> readHeaders(BufferedReader reader) throws Exception{
    var line = reader.readLine();

    var headers = new HashMap<String, List<String>>();

    while (line != null && !line.isEmpty()){
        System.out.println("next header line ... "+ line);
        var keyValue = line.split(":",2);
        var key = keyValue[0];
        var value = keyValue[1];
        headers.computeIfAbsent(key, k -> new ArrayList<>()).add(value); 
        line = reader.readLine();
    }

    return headers;
} 


private record HttpReq(
                    String method,
                    String url,
                    Map<String, List<String>> headers,
                    byte[] body){};

}
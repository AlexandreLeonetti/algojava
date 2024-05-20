/* gavilan.blog anatomy-of-an-http-request */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class HttpServerApp {
    public static void main(String[] args) throws Exception{
        var serverSocket = new ServerSocket(8080);


        while(true){
            var connection  = serverSocket.accept();
            var request     = readRequest(connection);            

            System.out.println("We have a request ... "+ request);
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

        return new HttpReq(method, url,Map.of(),null);
    }finally{
        System.out.println("Finally");
    }
}

private record HttpReq(
                    String method,
                    String url,
                    Map<String, List<String>> header,
                    byte[] body){};

}
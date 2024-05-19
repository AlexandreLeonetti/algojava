import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.Log;

public class Main{
    public static void main(String[] artgs){
           List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,0,1,0,0,0,2,2,1,1,2,0,0,2,1,1)) ;
           int p = 1;
           lib.Log.logger(list1);

           for(int i=0; i<list1.size(); i++){
                for(int j=i; j<list1.size(); j++){
                    if(list1.get(j)<p){
                        int c = list1.get(j);
                        list1.set(j,list1.get(i));
                        list1.set(i,c);

                    }
                    
                }
           }

           for(int i=list1.size()-1; i>0; i--){
            for(int j = 0; j<i;j++){
                if(list1.get(j)>p){
                    int c = list1.get(j);
                    list1.set(j,list1.get(i));
                    list1.set(i,c);
                }
                
            }
           }

           lib.Log.logger(list1);
    }

}
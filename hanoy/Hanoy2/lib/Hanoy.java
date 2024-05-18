package lib;


import java.util.List;
 
public class Hanoy {
    public static void sort (int n, List<Integer> origin, List<Integer> helper, List<Integer> destination){
        if(n<=0){
            return;
        }

        if(n>0){
            sort(n-1,  origin, destination, helper);
                int element = origin.remove(origin.size()-1);
                destination.add(element);
             sort(n-1, helper, origin, destination );
        }

    } 
    
}
/* javac ./lib/*.java Main.java */ 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import lib.Hanoy;
import lib.Log;

public class Main{
    public static void main (String[] args){
        /* declare three lists and log them */
        List<Integer> list1 = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        List <Integer> list2= new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

            Log.logger(list1);
            Log.logger(list2);
            Log.logger(list3);

            /* call Hanoy sort */
            lib.Hanoy.sort(5, list1, list2, list3);


            /* display all three lists in order */
            Log.logger(list1);
            Log.logger(list2);
            Log.logger(list3);
    }

}
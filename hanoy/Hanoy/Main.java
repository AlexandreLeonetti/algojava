import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import first.Hanoy;
import first.Log;

public  class Main {
    public static void main( String[] args){
            /* instatiate three lists  and display them*/
            List<Integer> list1 = new ArrayList<>(Arrays.asList(5,4,3,2,1));
            List<Integer> list2 = new ArrayList<>();
            List<Integer> list3 = new ArrayList<>();

            Log.logger(list1);
            Log.logger(list2);
            Log.logger(list3);

            /* call Hanoy sort */
            Hanoy.sort(5, list1, list2, list3);


            /* display all three lists in order */
            Log.logger(list1);
            Log.logger(list2);
            Log.logger(list3);


    }
}
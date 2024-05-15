import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args){
        // Instantiate Hanoy class

        List<Integer> arr1 = new ArrayList<>(Arrays.asList(3,2,1));
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();

        Log.logger(arr1);
        Log.logger(arr2);
        Log.logger(arr3);

        Hanoy.sort(3, arr1, arr2, arr3);
        
        System.out.println("sorted arrays");
        Log.logger(arr1);
        Log.logger(arr2);
        Log.logger(arr3);
    }
}
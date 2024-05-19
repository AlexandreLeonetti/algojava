/* binary search */


import java.util.Arrays;

public class Main {

    public static int search(int x, int[] arr){
        int low = 0;
        int high = arr.length;
        int index = 0;


        while (low!=high){
            int mid = (low+high)/2;
            System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);

            if(x>arr[mid]){
                low= mid+1;

            }else if( arr[mid]>x){
                high = mid-1;
            }else if(x==arr[mid]){
                return mid;
            }
        }
        return -1;

    }
    public static void main(String[] args){
        int[] a = {0,1,2,3,4,5,5,5,6,7,8,8,8,9,3000,1000000};
        int res = search (6, a);

        System.out.println(Arrays.toString(a));
        System.out.println(res);




    }
}
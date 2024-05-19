import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import lib.Log;
import lib.Hanoy;

public class Main {
	public static void main (String[] args){
		/* declare 3 lists */
		List<Integer> list1 = new ArrayList<>(Arrays.asList(3,2,1));
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		/* show lists */
		lib.Log.logger(list1);
		lib.Log.logger(list2);
		lib.Log.logger(list3);

		/* call hanoy.sort */
		lib.Hanoy.sort(3, list1, list2, list3);

		/* show lists again */
		lib.Log.logger(list1);
		lib.Log.logger(list2);
		lib.Log.logger(list3);

		
	}
}



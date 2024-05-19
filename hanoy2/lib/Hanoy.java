package lib;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Hanoy {
	public static void sort(int n, List<Integer> origin, List<Integer> helper, List<Integer> destination){
		if(n>0){
			sort(n-1, origin, destination, helper);
			// move one disk from origin to destination;
			//destination.push(origin.pop()); in JS
			destination.add(origin.remove(origin.size() - 1));
			sort(n-1, helper, origin, destination);
		}

	}
}

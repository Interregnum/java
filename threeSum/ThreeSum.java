package threeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * @author Mengchao Zhong
 */
public class ThreeSum {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(array1));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public static List<List<Integer>> threeSum(int[] num) {
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	for(int i = 0; i < num.length - 2; ++i) {
        	int first = num[i];
        	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        	for(int j = i + 1; j < num.length; ++j) {
        		if(map.containsKey(0 - first - num[j])) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(first);
        			list.add(num[j]);
        			list.add(0 - first - num[j]);
        			Collections.sort(list);
        			set.add(list);
        		}
        		map.put(num[j], true);
        	}
        }
    	return new ArrayList<List<Integer>>(set);
    }
}

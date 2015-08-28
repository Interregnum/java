package containsDuplicateII;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * @author Mengchao Zhong
 */
public class ContainsDuplicateII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{0, 1, 3, 5, 2, 1, 4, 5, 2, 5}, 3));
		System.out.println(containsNearbyDuplicate(new int[]{0, 1, 3, 5, 2, 1, 4, 5, 2, 3, 0}, 3));
	}
	
	/**
	 * Solution.
	 * @param nums
	 * @param k
	 * @return
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; ++i) {
        	if(map.containsKey(nums[i])) {
        		int last = map.get(nums[i]);
        		if(i - last <= k) {
        			return true;
        		}
        		else {
        			map.put(nums[i], i);
        		}
        	}
        	else {
        		map.put(nums[i], i);
        	}
        }
    	return false;
    }
}

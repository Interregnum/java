package containsDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * @author Mengchao Zhong
 */
public class ContainsDuplicate {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {2, 2, 4, 6};
		int[] nums3 = {3};
		System.out.println(containsDuplicate(nums1));
		System.out.println(containsDuplicate(nums2));
		System.out.println(containsDuplicate(nums3));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> checkDuplicate = new HashMap<Integer, Boolean>();
    	for(int i = 0; i < nums.length; ++i) {
        	if(checkDuplicate.containsKey(nums[i])) {
        		return true;
        	}
        	else {
        		checkDuplicate.put(nums[i], true);
        	}
        }
    	return false;
    }
}

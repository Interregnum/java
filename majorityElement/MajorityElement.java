package majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author Mengchao Zhong
 */
public class MajorityElement {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 1, 1, 1, 2, 2, 2, 2, 2};
		int[] nums2 = {3, 4, 4, 4, 4, 4, 4, 4, 4};
		int[] nums3 = {1, 2, 3, 4, 5, 5, 5, 5, 5};
		System.out.println(majorityElement(nums1));
		System.out.println(majorityElement(nums2));
		System.out.println(majorityElement(nums3));
		System.out.println(majorityElement2(nums1));
		System.out.println(majorityElement2(nums2));
		System.out.println(majorityElement2(nums3));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int maxNum = 0;
        for(int i = 0; i < nums.length; ++i) {
        	if(countMap.containsKey(nums[i])) {
        		countMap.put(nums[i], countMap.get(nums[i]) + 1);
        	}
        	else {
        		countMap.put(nums[i], 1);
        	}
        	if(maxCount < countMap.get(nums[i])) {
        		maxCount = countMap.get(nums[i]);
        		maxNum = nums[i];
        	}
        }
        return maxNum;
    }
    
    /**
     * Solution: Bit Manipulation.
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
    	int maxNum = 0;
    	for(int i = 0; i < 32; ++i) {
    		int numOfZero = 0;
    		for(int j = 0; j < nums.length; ++j) {
    			if((nums[j] >> i) % 2 == 0) {
    				++numOfZero;
    			} 
    		}
    		if(numOfZero > nums.length / 2) {
    			maxNum = maxNum | (0 << i); 
    		}
    		else {
    			maxNum = maxNum | (1 << i);
    		}
    	}
    	return maxNum;
    }
}

package singleNumberIII;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * @author Mengchao Zhong
 */
public class SingleNumberIII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 1, 2, 7, 4, 5, 5};
		int[] nums2 = {0, 1, 1, 2};
		System.out.println(singleNumber(nums1));
		System.out.println(singleNumber(nums2));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int[] singleNumber(int[] nums) {
        int[] output = new int[2];
        int aXorB = 0;
        
        for(int i = 0; i < nums.length; ++i) {
    		aXorB ^= nums[i];
    	}
        
        for(int i = 0; i < 32; ++i) {
        	if((aXorB & (1 << i)) != 0) {
        		for(int j = 0; j < nums.length; ++j) {
            		if((nums[j] & (1 << i)) == 0) {
            			output[0] ^= nums[j];
            		}
            		else {
            			output[1] ^= nums[j];
            		}
            	}
        		break;
        	}
        }
        return output;
    }
}

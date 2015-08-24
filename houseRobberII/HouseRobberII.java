package houseRobberII;

/**
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author Mengchao Zhong
 */
public class HouseRobberII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 3, 2, 4, 5, 1, 2, 4, 3};
		int[] nums2 = {0, 4, 6, 3, 12, 6, 0, 3, 6};
		int[] nums3 = {};
		int[] nums4 = {1};
		int[] nums5 = {0, 4};
		int[] nums6 = {2, 1, 1, 1};
		System.out.println(rob(nums1));
		System.out.println(rob(nums2));
		System.out.println(rob(nums3));
		System.out.println(rob(nums4));
		System.out.println(rob(nums5));
		System.out.println(rob(nums6));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int rob(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	if(nums.length == 2) {
    		return nums[0] > nums[1] ? nums[0] : nums[1];
    	}
    	
    	int[] excludeFirst = new int[nums.length];
    	int[] excludeLast = new int[nums.length];
    	
    	excludeFirst[0] = 0;
    	excludeFirst[1] = nums[1];
    	excludeFirst[2] = nums[2];
    	excludeLast[0] = 0;
    	excludeLast[1] = nums[0];
    	excludeLast[2] = nums[1];
    	
    	for(int i = 3; i < nums.length; ++i) {
    		excludeFirst[i] = nums[i] + (excludeFirst[i - 2] > excludeFirst[i - 3] ? excludeFirst[i - 2] : excludeFirst[i - 3]);
    		excludeLast[i] = nums[i - 1] + (excludeLast[i - 2] > excludeLast[i - 3] ? excludeLast[i - 2] : excludeLast[i - 3]);
    	}
    	
    	int excludeFirstMax = excludeFirst[nums.length - 1] > excludeFirst[nums.length - 2] ? excludeFirst[nums.length - 1] : excludeFirst[nums.length - 2];
    	int excludeLastMax = excludeLast[nums.length - 1] > excludeLast[nums.length - 2] ? excludeLast[nums.length - 1] : excludeLast[nums.length - 2];
    	
    	return excludeFirstMax > excludeLastMax ? excludeFirstMax : excludeLastMax;
    }
}

package houseRobber;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author Mengchao Zhong
 */
public class HouseRobber {

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
		System.out.println(rob(nums1));
		System.out.println(rob(nums2));
		System.out.println(rob(nums3));
		System.out.println(rob(nums4));
		System.out.println(rob(nums5));
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
        else if(nums.length == 1) {
        	return nums[0];
        }
        else if(nums.length == 2) {
        	return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        else {
        	int[] dp = new int[nums.length + 1];
        	dp[0] = 0;
        	dp[1] = nums[0];
        	dp[2] = nums[1];
            
            for(int i = 3; i < dp.length; ++i) {
            	dp[i] = nums[i - 1] + (dp[i - 2] > dp[i - 3] ? dp[i - 2] : dp[i - 3]);
            }
            
            return dp[dp.length - 1] > dp[dp.length - 2] ? dp[dp.length - 1] : dp[dp.length - 2];
        }
    }
}

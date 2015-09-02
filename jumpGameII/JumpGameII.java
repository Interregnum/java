package jumpGameII;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * @author Mengchao Zhong
 */
public class JumpGameII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(jump3(new int[] {1, 2}));
		System.out.println(jump3(new int[] {2, 3, 1, 1, 4}));
	}

	/**
	 * Solution: Recursion - TLE.
	 * @param nums
	 * @return
	 */
	static int minSteps = Integer.MAX_VALUE;
	
    public static int jump(int[] nums) {
    	jumpFromCurrentIndex(nums, 0, 0);
        return minSteps;
    }
    
    public static void jumpFromCurrentIndex(int[] nums, int currIndex, int steps) {
    	if(currIndex >= nums.length - 1) {
    		if(steps < minSteps) {
    			minSteps = steps;
    		}
    	}
    	else {
    		for(int i = 1; i <= nums[currIndex]; ++i) {
    			jumpFromCurrentIndex(nums, currIndex + i, steps + 1);
    		}
    	}
    }
    
    /**
     * Solution: Dynamic Programming - TLE.
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
    	int[] dp = new int[nums.length];
    	dp[0] = 0;
    	
    	for(int i = 1; i < nums.length; ++i) {
    		int minSteps = i;
    		for(int j = 0; j < i; ++j) {
    			if(dp[j] + nums[j] >= i) {
    				if(dp[j] + 1 < minSteps) {
    					minSteps = dp[j] + 1;
    				}
    			}
    		}
    		dp[i] = minSteps;
    	}
    	
    	return dp[nums.length - 1];
    }
    
    /**
     * Solution.
     * @param nums
     * @return
     */
    public static int jump3(int[] nums) {
    	int steps = 0;
    	for(int i = 0; i < nums.length - 1;) {
    		++steps;
    		if(i + nums[i] >= nums.length - 1) {
    			return steps;
    		}

    		int nextIndex = i;
    		int maxIndex = i;
    		int moveIndex = i + 1;
    		while(moveIndex <= i + nums[i]) {
    			if(moveIndex + nums[moveIndex] > maxIndex) {
    				maxIndex = moveIndex + nums[moveIndex];
    				nextIndex = moveIndex;
    			}
    			moveIndex++;
    		}
    		
    		if(nextIndex == i) {
    			return -1;
    		}
    		else {
    			i = nextIndex;
    		}
    	}
    	return steps;
    }
}
package minimumSizeSubarraySum;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum >= s. If there isn't one, return 0 instead.
 * @author Mengchao Zhong
 */
public class MinimumSizeSubarraySum {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
	}

	/**
	 * Solution.
	 * @param s
	 * @param nums
	 * @return
	 */
    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; ++i) {
        	if(sum < s) {
        		++end;
        		sum += nums[i];
        	}
        	else {
        		break;
        	}
        }
        if(sum < s) {
        	return 0;
        }
        else {
        	minLength = end - start;
        	while(end <= nums.length) {
    			while(sum - nums[start] >= s) {
    				sum = sum - nums[start];
    				++start;
    			}
    			if(minLength > end - start) {
            		minLength = end - start;
            	}
    			if(end < nums.length) {
    				sum += nums[end];
    			}
    			++end;
        	}
        	return minLength;
        }
    }
}

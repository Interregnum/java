package maximumSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * @author Mengchao Zhong
 */
public class MaximumSubarray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {-10, 19, 2, 3, 0, -4, 0, -6, 4, 3, 4, 5, -2, 4};
		System.out.println(maxSubArray(array));
	}

	/**
	 * Solution: O(n).
	 * @param A
	 * @return
	 */
    public static int maxSubArray(int[] A) {
    	int sum = 0;
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < A.length; ++i) {
    		sum += A[i];
    		if(sum > max) {
    			max = sum;
    		}
    		if(sum < 0) {
    			sum = 0;
    		}
    	}
    	return max;
    }
}

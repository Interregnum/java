package trappingRainWater;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * @author Mengchao Zhong
 */
public class TrappingRainWater {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(trap(array1));
	}

	/**
	 * Solution.
	 * @param A
	 * @return
	 */
    public static int trap(int[] A) {
        int totalVolume = 0;
        int[] rightMax = new int[A.length];
        int right = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;
        for(int i = A.length - 1; i >= 0; --i) {
        	right = Math.max(right, A[i]);
        	rightMax[i] = right;
        }
        for(int i = 0; i < A.length; ++i) {
        	left = Math.max(left, A[i]);
        	totalVolume += (Math.min(left, rightMax[i]) - A[i]);
        }
    	return totalVolume;
    }
}

package threeSumClosest;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * @author Mengchao Zhong
 */
public class ThreeSumClosest {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(nums1, 1));
	}

	/**
	 * Solution.
	 * @param num
	 * @param target
	 * @return
	 */
    public static int threeSumClosest(int[] num, int target) {
        int diff = Integer.MAX_VALUE;
    	for(int i = 0; i < num.length - 2; ++i) {
        	for(int j = i + 1; j < num.length - 1; ++j) {
        		for(int k = j + 1; k < num.length; ++k) {
        			if(Math.abs(num[i] + num[j] + num[k] - target) < Math.abs(diff)) {
        				diff = num[i] + num[j] + num[k] - target;
        			}
        		}
        	}
        }
    	return diff + target;
    }
}

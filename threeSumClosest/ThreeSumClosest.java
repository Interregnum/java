package threeSumClosest;

import java.util.Arrays;

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
    	Arrays.sort(num);
        int sum = num[0] + num[1] + num[2];
    	for(int i = 0; i < num.length - 2; ++i) {
        	for(int j = i + 1; j < num.length - 1; ++j) {
        		int lower = j + 1;
        		int upper = num.length - 1;
        		while(lower <= upper) {
        			int middle = lower + (upper - lower) / 2;
        			if(Math.abs(num[i] + num[j] + num[middle] - target) < Math.abs(sum - target)) {
        				sum = num[i] + num[j] + num[middle];
        			}
        			if(num[i] + num[j] + num[middle] == target) {
        				return target;
        			}
        			else if (num[i] + num[j] + num[middle] > target) {
        				upper = middle - 1;
        			}
        			else {
        				lower = middle + 1;
        			}
        		}
        	}
        }
    	return sum;
    }
}

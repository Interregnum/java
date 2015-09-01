package maximumGap;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * @author Mengchao Zhong
 */
public class MaximumGap {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] {0, 1, 23, 15, 3, 13, 8, 9, 8, 4, 3}));
		System.out.println(maximumGap2(new int[] {100, 3, 2, 1}));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int maximumGap(int[] nums) {
        int maxGap = 0;
    	Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i) {
        	if(nums[i] - nums[i - 1] > maxGap) {
        		maxGap = nums[i] - nums[i - 1];
        	}
        }
        return maxGap;
    }
    
	/**
	 * Solution: Bucket Sort.
	 * @param nums
	 * @return
	 */
    public static int maximumGap2(int[] nums) {
    	if(nums.length < 2) {
    		return 0;
    	}
    	
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] > max) {
        		max = nums[i];
        	}
        	if(nums[i] < min) {
        		min = nums[i];
        	}
        }
    	
    	int interval = (int) Math.ceil((double)(max - min) / (nums.length - 1));
    	int[][] brackets = new int[2][(max - min) / interval + 1];
    	for(int i = 0; i < brackets[0].length; ++i) {
    		brackets[0][i] = Integer.MAX_VALUE;
    		brackets[1][i] = Integer.MIN_VALUE;
    	}
    	
    	for(int i = 0; i < nums.length; ++i) {
    		if(brackets[0][(nums[i] - min) / interval] > nums[i]) {
    			brackets[0][(nums[i] - min) / interval] = nums[i];
    		}
    		if(brackets[1][(nums[i] - min) / interval] < nums[i]) {
    			brackets[1][(nums[i] - min) / interval] = nums[i];
    		}
    	}
    	
    	int maxGap = interval;
    	for(int prev = 0, curr = 1; curr < brackets[0].length;) {
    		if(brackets[0][prev] == Integer.MAX_VALUE) {
    			++prev;
    			++curr;
    		}
    		else if(brackets[0][curr] == Integer.MAX_VALUE) {
    			++curr;
    		}
    		else {
    			if(brackets[0][curr] - brackets[1][prev] > maxGap) {
    				maxGap = brackets[0][curr] - brackets[1][prev];
    			}
				prev = curr;
    			curr = curr + 1;
    		}
    	}
    	
    	return maxGap;
    }
}

package permutationsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * @author Mengchao Zhong
 */
public class PermutationsII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num1 = {-1, 2, 0, -1, 1, 0, 1};
		int[] num2 = {1, 1, 2};
		System.out.println(permuteUnique(num1));
		System.out.println(permuteUnique(num2));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
	public static List<List<Integer>> output = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
        recursion(0, nums);
        return output;
    }
    
    public static void recursion(int index, int[] nums) {
    	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    	if(index == nums.length - 1) {
    		List<Integer> permutation = new ArrayList<Integer>();
    		for(int i = 0; i < nums.length; ++i) {
    			permutation.add(nums[i]);
    		}
    		output.add(permutation);
    		return;
    	}
    	for(int i = index; i < nums.length; ++i) {
    		if(i == index) {
    			recursion(index + 1, nums);
    		}
    		else {
        		if(!map.containsKey(nums[i]) && nums[i] != nums[index]) {
        			int tmp = 0;
        			tmp = nums[i];
        			nums[i] = nums[index];
        			nums[index] = tmp;
        			recursion(index + 1, nums);
        			tmp = nums[i];
        			nums[i] = nums[index];
        			nums[index] = tmp;
        			
        			map.put(nums[i], true);
        		}
    		}
    	}
    }
}
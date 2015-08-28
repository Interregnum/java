package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * @author Mengchao Zhong
 */
public class CombinationSumII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		System.out.println(combinationSum2(nums, 8));
	}

	/**
	 * Solution.
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static Set<List<Integer>> output = new HashSet<List<Integer>>();
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	recursion(candidates, 0, target, new ArrayList<Integer>());
    	return new ArrayList<List<Integer>>(output);
    }
    
    public static void recursion(int[] candidates, int start, int target, List<Integer> combo) {
    	if(target > 0) {
    		for(int i = start; i < candidates.length && candidates[i] <= target; ++i) {
    			combo.add(candidates[i]);
    			recursion(candidates, i + 1, target - candidates[i], combo);
    			combo.remove(combo.size() - 1);
    		}
    	}
    	else if(target == 0) {
    		if(!output.contains(combo)) {
    			output.add(new ArrayList<Integer>(combo));
    		}
    	}
    }
}

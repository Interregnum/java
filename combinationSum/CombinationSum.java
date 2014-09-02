package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * @author Mengchao Zhong
 */
public class CombinationSum {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {2, 3, 6, 7};
		System.out.println(combinationSum(array1, 7));
	}

	private static List<List<Integer>> output = new ArrayList<List<Integer>>();
	
	/**
	 * Solution.
	 * @param candidates
	 * @param target
	 * @return
	 */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        traverse(candidates, 0, target, new ArrayList<Integer>());
        return output;
    }
    
    public static void traverse(int[] candidates, int index, int target, List<Integer> solution) {
    	while(index < candidates.length && candidates[index] <= target) {
    		List<Integer> update = new ArrayList<Integer>(solution);
    		update.add(candidates[index]);
    		if(candidates[index] == target) {
    			output.add(update);
    			return;
    		}
    		traverse(candidates, index, target - candidates[index], update);
    		++index;
    	}
    }
}

package combinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * @author Mengchao Zhong
 */
public class CombinationSumIII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param k
	 * @param n
	 * @return
	 */
	List<List<Integer>> combinations = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(new ArrayList<Integer>(), k, n, 1);
        return combinations;
    }
    
    public void recursion(List<Integer> list, int count, int num, int index) {
    	if(num == 0 && count == 0) {
    		combinations.add(list);
    	}
    	else if(count == 0) {
    		return;
    	}
    	else {
	    	for(int i = index; i < (num >= 10 ? 10 : num + 1); ++i) {
	    		List<Integer> newList = new ArrayList<Integer>(list);
	    		newList.add(i);
	    		recursion(newList, count - 1, num - i, i + 1);
	    	}
    	}
    }
}

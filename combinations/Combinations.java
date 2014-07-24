package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * @author Mengchao Zhong
 */
public class Combinations {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(combine(13, 13));
	}

	private static List<List<Integer>> output = new ArrayList<List<Integer>>();
	
	/**
	 * Solution.
	 * @param n
	 * @param k
	 * @return
	 */
    public static List<List<Integer>> combine(int n, int k) {
    	List<Integer> result = new ArrayList<Integer>(k);
    	search(result, 1, n, k);
    	return output;
    }
    
    public static void search(List<Integer> result, int cur, int n, int k) {
    	if(k < 1) {
    		output.add(new ArrayList<Integer>(result));
    		return;
    	}
    	
    	for(int i = cur; i <= n; ++i) {
    		result.add(i);
    		search(result, i + 1, n, k - 1);
    		result.remove(result.size() - 1);
    	}
    }
}

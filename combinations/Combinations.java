package combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	private static Set<List<Integer>> output = new HashSet<List<Integer>>();
	
	/**
	 * Solution.
	 * @param n
	 * @param k
	 * @return
	 */
    public static List<List<Integer>> combine(int n, int k) {
    	List<Integer> candidate = new ArrayList<Integer>(n);
    	List<Integer> result = new ArrayList<Integer>(k);
    	for(int i = 0; i < n; ++i) {
    		candidate.add(i + 1);
    	}
    	search(candidate, result, n, k);
    	return new ArrayList<List<Integer>>(output);
    }
    
    public static void search(List<Integer> candidate, List<Integer> result, int n, int k) {
    	if(k < 1) {
    		List<Integer> tmp = new ArrayList<Integer>(result);
    		Collections.sort(tmp);
    		output.add(tmp);
    		return;
    	}
    	
    	for(int i = 0; i < n; ++i) {
    		result.add(candidate.get(i));
    		int removed = candidate.remove(i);
    		System.out.println(result);
    		System.out.println(candidate);
    		search(candidate, result, n - 1, k - 1);
    		candidate.add(i, removed);
    		result.remove(result.size() - 1);
    	}
    }
}

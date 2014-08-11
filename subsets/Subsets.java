package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * @author Mengchao Zhong
 */
public class Subsets {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num1 = {4, 3, 2, 1, 0};
		System.out.println(subsets(num1));
	}

	/**
	 * Solution.
	 * @param S
	 * @return
	 */
    public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        output.add(current);
        for(int i = 0; i < S.length; ++i) {
        	List<List<Integer>> subsets = new ArrayList<List<Integer>>(output);
        	for(List<Integer> subset : subsets) {
        		List<Integer> newSubset = new ArrayList<Integer>(subset);
        		newSubset.add(S[i]);
        		output.add(newSubset);
        	}
        }
        return output;
    }
}

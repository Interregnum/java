package subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * @author Mengchao Zhong
 */
public class SubsetsII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        output.add(new ArrayList<Integer>());
        for(int i = 0; i < num.length; ++i) {
        	Set<List<Integer>> tmp = new HashSet<List<Integer>>();
        	for(List<Integer> cur : output) {
        		List<Integer> update = new ArrayList<Integer>(cur);
        		update.add(num[i]);
        		tmp.add(update);
        	}
        	output.addAll(tmp);
        }
        return new ArrayList<List<Integer>>(output);
    }
}

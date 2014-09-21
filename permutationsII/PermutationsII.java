package permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int[] num1 = {1, 2, 3};
		System.out.println(permute(num1));
	}

	private static Set<List<Integer>> result = new HashSet<List<Integer>>();
	
	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public static List<List<Integer>> permute(int[] num) {
    	Arrays.sort(num);
    	List<Integer> numbers = new ArrayList<Integer>();
    	for(int i = 0; i < num.length; ++i) {
    		numbers.add(num[i]);
    	}
    	search(0, numbers);
    	return new ArrayList<List<Integer>>(result);
    }
    
    public static void search(int index, List<Integer> num) {
    	if(index == num.size()) {
    		return;
    	}
    	for(int i = index; i < num.size(); ++i) {
    		List<Integer> current = new ArrayList<Integer>(num);
        	int tmp = current.get(index);
        	current.set(index, current.get(i));
        	current.set(i, tmp);
        	result.add(current);
        	search(index + 1, current);
    	}
    }
}
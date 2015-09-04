package permutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,Åc,n] contains a total of n! unique permutations.
 * Given n and k, return the kth permutation sequence.
 * Given n will be between 1 and 9 inclusive.
 * @author Mengchao Zhong
 */
public class PermutationSequence {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getPermutation(3, 2));
		System.out.println(getPermutation(3, 5));
		System.out.println(getPermutation(3, 6));
	}

	/**
	 * Solution.
	 * @param n
	 * @param k
	 * @return
	 */
    public static String getPermutation(int n, int k) {
    	List<Integer> list = new ArrayList<Integer>();
    	int factorialN = 1;
    	for(int i = 1; i <= n; ++i) {
        	list.add(i);
        	factorialN *= i;
        }
    	StringBuilder output = new StringBuilder();
    	
    	while(n > 0) {
    		if(n == 1) {
            	output.append(list.remove(0));
            } 
    		else {
	    		output.append(list.remove((k - 1) % factorialN * n / factorialN));
	    		factorialN /= n;
    		}
    		--n;
    	}
    	
    	return output.toString();
    }
}

package grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * @author Mengchao Zhong
 */
public class GrayCode {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(grayCode(1));
		System.out.println(grayCode(2));
		System.out.println(grayCode(3));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static List<Integer> grayCode(int n) {
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        List<Integer> dp1 = new ArrayList<Integer>();
        dp1.add(0);
        if(n == 0) {
        	return dp1;
        }
        dp1.add(1);
        dp.add(dp1);
        for(int i = 1; i < n; ++i) {
        	List<Integer> prev = dp.get(i - 1);
        	List<Integer> cur = new ArrayList<Integer>(prev);
        	for(int j = prev.size() - 1; j >= 0; --j) {
        		cur.add(prev.get(j) + (1 << i));
        	}
        	dp.add(cur);
        }
        return dp.get(n - 1);
    }
}

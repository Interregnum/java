package perfectSquares;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * @author Mengchao Zhong
 */
public class PerfectSquares {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
		System.out.println(numSquares(51));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
	private static int nums = Integer.MAX_VALUE;
	
    public static int numSquares(int n) {
    	recursion(n, 0);
    	return nums;
    }
    
    public static void recursion(int remaining, int count) {
    	if(remaining == 0) {
    		if(count < nums) {
    			nums = count;
    		}
    	}
    	else {
    		int maxSqrt = (int) Math.sqrt(remaining);
    		for(int i = 1; i <= maxSqrt; ++i) {
    			int maxSq = i * i;
    			int times = remaining / maxSq;
    			recursion(remaining - times * maxSq, count + times);
    		}
    	}
    }
}

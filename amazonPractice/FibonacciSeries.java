package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class FibonacciSeries {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacciRecursion(-10));
		System.out.println(fibonacciRecursion(0));
		System.out.println(fibonacciRecursion(2));
		System.out.println(fibonacciRecursion(3));
		System.out.println(fibonacciRecursion(4));
		System.out.println(fibonacciRecursion(6));
		System.out.println(fibonacciDynamic(-10));
		System.out.println(fibonacciDynamic(0));
		System.out.println(fibonacciDynamic(2));
		System.out.println(fibonacciDynamic(3));
		System.out.println(fibonacciDynamic(4));
		System.out.println(fibonacciDynamic(6));
		System.out.println(fibonacciIterative(-10));
		System.out.println(fibonacciIterative(0));
		System.out.println(fibonacciIterative(2));
		System.out.println(fibonacciIterative(3));
		System.out.println(fibonacciIterative(4));
		System.out.println(fibonacciIterative(6));
	}

	/**
	 * Solution: Recursive.
	 * @param n
	 * @return
	 */
	public static int fibonacciRecursion(int n) {
		if(n < 0) {
			return 0;
		}
		if(n < 2) {
			return 1;
		}
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
	
	/**
	 * Solution: Dynamic Programming.
	 * @param n
	 * @return
	 */
	public static int fibonacciDynamic(int n) {
		if(n < 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		if(n > 0) {
			dp[1] = 1;
		}
		for(int i = 2; i <= n; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	/**
	 * Solution: Iterative.
	 * @param n
	 * @return
	 */
	public static int fibonacciIterative(int n) {
		if(n < 0) {
			return 0;
		}
		if(n < 2) {
			return 1;
		}
		int count = 2;
		int left = 1;
		int right = 1;
		while(n > count++ - 1) {
			int tmp = right;
			right = left + right;
			left = tmp;
		}
		return right;
	}
}
package uniqueBinarySearchTrees;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * @author Mengchao Zhong
 */
public class UniqueBinarySearchTrees {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static int numTrees(int n) {
    	/**
    	 * dp[i] => Number of unique binary search trees which has i nodes
    	 */
    	int[] dp = new int[n + 1];
    	dp[0] = dp[1] = 1;
    	for(int i = 2; i < n + 1; ++i) {
    		dp[i] = 0;
    		for(int j = 0; j < i; ++j) {
    			dp[i] += dp[j] * dp[i - j - 1];
    		}
    	}
    	return dp[n];
    }
}

package uniquePaths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * @author Mengchao Zhong
 */
public class UniquePaths {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(uniquePaths(10, 19));
		System.out.println(uniquePaths(19, 10));
		System.out.println(uniquePaths(10, 2));
		System.out.println(uniquePaths(1, 10));
	}

	/**
	 * Solution.
	 * @param m
	 * @param n
	 * @return
	 */
    public static int uniquePaths(int m, int n) {
    	int[][] dp = new int[n][m];
    	for(int i = 0; i < m; ++i) {
    		dp[0][i] = 1;
    	}
    	for(int i = 0; i < n; ++i) {
    		dp[i][0] = 1;
    	}
    	for(int i = 1; i < m; ++i) {
    		for(int j = 1; j < n; ++j) {
    			dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
    		}
    	}
    	return dp[n - 1][m - 1];
    }
}

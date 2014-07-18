package minimumPathSum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * @author Mengchao Zhong
 */
public class MinimumPathSum {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(minPathSum(matrix));
	}

	/**
	 * Solution.
	 * @param grid
	 * @return
	 */
    public static int minPathSum(int[][] grid) {
    	if(null == grid || grid.length == 0) {
    		return 0;
    	}
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < dp.length; ++i) {
        	dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int i = 1; i < dp[0].length; ++i) {
        	dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        
        for(int i = 1; i < dp.length; ++i) {
        	for(int j = 1; j < dp[0].length; ++j) {
        		dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
        	}
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

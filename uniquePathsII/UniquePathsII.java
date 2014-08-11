package uniquePathsII;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * @author Mengchao Zhong
 */
public class UniquePathsII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] board1 = {{0, 0}, {1, 1}, {0, 0}};
		System.out.println(uniquePathsWithObstacles(board1));
	}

	/**
	 * Solution.
	 * @param obstacleGrid
	 * @return
	 */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0) {
    		return 0;
    	}
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int mark = 1;
        for(int i = 0; i < obstacleGrid[0].length; ++i) {
        	if(obstacleGrid[0][i] == 1) {
        		mark = 0;
        	}
        	dp[0][i] = mark;
        }
        mark = 1;
        for(int i = 0; i < obstacleGrid.length; ++i) {
        	if(obstacleGrid[i][0] == 1) {
        		mark = 0;
        	}
        	dp[i][0] = mark;
        }
        for(int i = 1; i < obstacleGrid.length; ++i) {
        	for(int j = 1; j < obstacleGrid[0].length; ++j) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		}
        		else {
        			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        		}
        	}
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

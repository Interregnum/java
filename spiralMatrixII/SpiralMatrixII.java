package spiralMatrixII;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @author Mengchao Zhong
 */
public class SpiralMatrixII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(5));
		System.out.println(generateMatrix(8));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static int[][] generateMatrix(int n) {
        int[][] output = new int[n][n];
        int num = 0;
        for(int i = 0; i < (n + 1) / 2; ++i) {
        	for(int j = i; j < n - i; ++j) {
        		output[i][j] = ++num;
        	}
        	for(int j = i + 1; j < n - i; ++j) {
        		output[j][n - i - 1] = ++num;
        	}
        	for(int j = i + 1; j < n - i; ++j) {
        		output[n - i - 1][n - j - 1] = ++num;
        	}
        	for(int j = i + 1; j < n - i - 1; ++j) {
        		output[n - j - 1][i] = ++num;
        	}
        }
        return output;
    }
}

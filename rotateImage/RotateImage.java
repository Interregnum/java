package rotateImage;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * @author Mengchao Zhong
 */
public class RotateImage {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int[][] matrix2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		rotate(matrix1);
		rotate(matrix2);
	}

	/**
	 * Solution.
	 * @param matrix
	 */
    public static void rotate(int[][] matrix) {
        int degree = matrix.length;
        
        for(int i = 0; i < degree / 2; ++i) {
        	for(int j = 0; j < degree - 2 * i - 1; ++j) {
        		int tmp = matrix[i][i + j];
        		matrix[i][i + j] = matrix[degree - i -j - 1][i];
        		matrix[degree - i - j - 1][i] = matrix[degree - i - 1][degree - i - j - 1];
        		matrix[degree - i - 1][degree - i - j - 1] = matrix[i + j][degree - i - 1];
        		matrix[i + j][degree - i - 1] = tmp;
        	}
        }
    }
}

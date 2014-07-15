package searchA2DMatrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * @author Mengchao Zhong
 */
public class SearchA2DMatrix {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix1 = {{1, 3, 5, 7},
		                   {10, 11, 16, 20},
		                   {23, 30, 34, 50}
		                  };
		System.out.println(searchMatrix(matrix1, 3));
		System.out.println(searchMatrix(matrix1, 16));
		System.out.println(searchMatrix(matrix1, 34));
		System.out.println(searchMatrix(matrix1, 51));
	}

	/**
	 * Solution.
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        for(int i = 0; i < rowNum; ++i) {
        	if(target == matrix[i][0]) {
        		return true;
        	}
        	else if(target < matrix[i][0]) {
        		if(i == 0) {
        			return false;
        		}
        		else {
        			for(int j = 0; j < matrix[i - 1].length; ++j) {
        				if(matrix[i - 1][j] == target) {
        					return true;
        				}
        			}
        			return false;
        		}
        	}
        	else {
        		if(i == rowNum - 1) {
        			for(int j = 0; j < matrix[i].length; ++j) {
        				if(matrix[i][j] == target) {
        					return true;
        				}
        			}
        			return false;
        		}
        		else {
            		continue;
        		}
        	}
        }
        return false;
    }
}

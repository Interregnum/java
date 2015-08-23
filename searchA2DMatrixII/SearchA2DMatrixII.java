package searchA2DMatrixII;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * @author Mengchao Zhong
 */
public class SearchA2DMatrixII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix1 = {{1, 4, 7, 11, 15},
		                   {2, 5, 8, 12, 19},
		                   {3, 6, 9, 16, 22},
		                   {10, 13, 14, 17, 24},
		                   {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(matrix1, 14));
		System.out.println(searchMatrix(matrix1, 30));
		System.out.println(searchMatrix(matrix1, 1));
		System.out.println(searchMatrix(matrix1, 18));
		System.out.println(searchMatrix(matrix1, 15));
		System.out.println(searchMatrix(matrix1, 0));
		System.out.println(searchMatrix(matrix1, 33));
	}

	/**
	 * Solution.
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;
        
        while(rowStart <= rowEnd && columnStart <= columnEnd) {
        	int start = 0;
        	int end = 0;
        	
        	if(rowStart <= rowEnd) {
		        start = columnStart;
		        end = columnEnd;
		        while(start < end) {
		        	int mid = start + (end - start) / 2;
		        	
		        	if(matrix[rowStart][mid] == target) {
		        		return true;
		        	}
		        	else if(matrix[rowStart][mid] < target) {
		        		start = mid + 1;
		        	}
		        	else {
		        		end = mid;
		        	}
		        }
		        
		        if(matrix[rowStart][end] == target) {
		        	return true;
		        }
		        else if(matrix[rowStart][end] > target) {
		        	columnEnd = end - 1;
		        }
		        
		        if(rowStart < rowEnd) {
		        	rowStart++;
		        }
        	}
	        
        	if(columnStart <= columnEnd) {
		        start = rowStart;
		        end = rowEnd;
		        while(start < end) {
		        	int mid = start + (end - start) / 2;
		        	
		        	if(matrix[mid][columnEnd] == target) {
		        		return true;
		        	}
		        	else if(matrix[mid][columnEnd] < target) {
			        	if(mid == start) {
			        		start = mid + 1;
			        	}
			        	else {
			        		start = mid;
			        	}
		        	}
		        	else {
		        		end = mid - 1;
		        	}
		        }
		        
		        if(matrix[start][columnEnd] == target) {
		        	return true;
		        }
		        else if(matrix[start][columnEnd] < target) {
		        	rowStart = start + 1;
		        }
		        
		        if(columnStart < columnEnd) {
		        	columnEnd--;
		        }
        	}
        }
        
        return false;
    }
}

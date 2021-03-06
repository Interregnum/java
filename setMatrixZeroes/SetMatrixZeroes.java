package setMatrixZeroes;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author Mengchao Zhong
 */
public class SetMatrixZeroes {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix1 = {{1, 0 ,2}, {0, 3, 1}, {4, 5, 2}};
		setZeroes(matrix1);
	}

	/**
	 * Solution.
	 * @param matrix
	 */
    public static void setZeroes(int[][] matrix) {
    	if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; ++i) {
        	for(int j = 0; j < matrix[0].length; ++j) {
        		if(matrix[i][j] == 0) {
        			row[i] = 1;
        			column[j] = 1;
        		}
        	}
        }
        for(int i = 0; i < row.length; ++i) {
    		for(int j = 0; j < matrix[0].length; ++j) {
    			if(row[i] == 1 || column[j] == 1) {
    				matrix[i][j] = 0;
    			}
    		}
        }
    }
    
    /**
     * Solution: O(1) Space.
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
    	if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	
    	boolean firstColumn = false;
    	boolean firstRow = false;
    	
    	for(int i = 0; i < matrix.length; ++i) {
    		if(matrix[i][0] == 0) {
    			firstColumn = true;
    			break;
    		}
    	}
    	for(int i = 0; i < matrix[0].length; ++i) {
    		if(matrix[0][i] == 0) {
    			firstRow = true;
    			break;
    		}
    	}
    	for(int i = 1; i < matrix.length; ++i) {
    		for(int j = 1; j < matrix[0].length; ++j) {
    			if(matrix[i][j] == 0) {
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}
    	for(int i = 1; i < matrix.length; ++i) {
    		for(int j = 1; j < matrix[0].length; ++j) {
    			if(matrix[i][0] == 0 || matrix[0][j] == 0) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	if(firstColumn) {
    		for(int i = 0; i < matrix.length; ++i) {
    			matrix[i][0] = 0;
        	}
    	}
    	if(firstRow) {
    		for(int i = 0; i < matrix[0].length; ++i) {
    			matrix[0][i] = 0;
        	}
    	}
    }
}

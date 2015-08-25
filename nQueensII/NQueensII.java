package nQueensII;

/**
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author Mengchao Zhong
 */
public class NQueensII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
		System.out.println(totalNQueens(2));
		System.out.println(totalNQueens(3));
		System.out.println(totalNQueens(4));
		System.out.println(totalNQueens(5));
		System.out.println(totalNQueens(6));
		System.out.println(totalNQueens(7));
		System.out.println(totalNQueens(8));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
	public static int total = 0;
	
    public static int totalNQueens(int n) {
        int[] state = new int[n];
        for(int i = 0; i < state.length; ++i) {
        	state[i] = -1;
        }
        placeQueenOnRow(state, 0);
        return total;
    }
    
    public static void placeQueenOnRow(int[] state, int row) {
    	if(row == state.length) {
    		++total;
    	}
    	else {
    		for(int i = 0; i < state.length; ++i) {
    			if(isValid(state, row, i)) {
    				state[row] = i;
    				placeQueenOnRow(state, row + 1);
    				state[row] = -1;
    			}
    		}
    	}
    }
    
    public static boolean isValid(int[] state, int row, int col) {
    	for(int i = 0; i < row; ++i) {
    		if(state[i] == col || Math.abs(row - i) == Math.abs(col - state[i])) {
    			return false;
    		}
    	}
    	return true;
    }
}

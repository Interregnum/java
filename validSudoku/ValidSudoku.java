package validSudoku;


/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * @author Mengchao Zhong
 */
public class ValidSudoku {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param board
	 * @return
	 */
    public boolean isValidSudoku(char[][] board) {
    	boolean[][] row = new boolean[9][9];
    	boolean[][] column = new boolean[9][9];
    	boolean[][] grid = new boolean[9][9];
    	for(int i = 0; i < 9; ++i) {
    		for(int j = 0; j < 9; ++j) {
    			if(board[i][j] != '.') {
	    			int x = board[i][j] - '1';
	    			int y = i / 3 * 3 + j / 3;
	    			if(row[i][x] || column[j][x] || grid[y][x]) {
	    				return false;
	    			}
	    			else {
	    				row[i][x] = column[j][x] = grid[y][x] = true;
	    			}
    			}
    		}
    	}
    	return true;
    }
}
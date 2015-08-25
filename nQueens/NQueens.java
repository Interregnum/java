package nQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * @author Mengchao Zhong
 */
public class NQueens {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(2));
		System.out.println(solveNQueens(3));
		System.out.println(solveNQueens(4));
		System.out.println(solveNQueens(5));
		System.out.println(solveNQueens(6));
		System.out.println(solveNQueens(7));
		System.out.println(solveNQueens(8));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
	public static List<List<String>> solutions = new ArrayList<List<String>>();
	
    public static List<List<String>> solveNQueens(int n) {
        int[] state = new int[n];
        for(int i = 0; i < state.length; ++i) {
        	state[i] = -1;
        }
        placeQueenOnRow(state, 0);
        return solutions;
    }
    
    public static void placeQueenOnRow(int[] state, int row) {
    	if(row == state.length) {
    		List<String> solution = new ArrayList<String>();
    		for(int i = 0; i < state.length; ++i) {
    			StringBuilder builder = new StringBuilder();
    			int preCount = 0;
    			int postCount = state.length - 1;
    			while(preCount++ < state[i]) {
    				builder.append(".");
    			}
    			builder.append("Q");
    			while(postCount-- > state[i]) {
    				builder.append(".");
    			}
    			solution.add(builder.toString());
    		}
    		solutions.add(solution);
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
    		if(state[i] == col || Math.abs(i - row) == Math.abs(state[i] - col)) {
    			return false;
    		}
    	}
    	return true;
    }
}

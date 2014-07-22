package pascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * @author Mengchao Zhong
 */
public class PascalsTriangleII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getRow(3));
		System.out.println(getRow(5));
		System.out.println(getRow(6));
	}

	/**
	 * Solution.
	 * @param rowIndex
	 * @return
	 */
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> output = new ArrayList<Integer>(rowIndex + 1);
    	output.add(1);
    	if(rowIndex > 0) {
    		output.add(1);
	        for(int i = 2; i <= rowIndex; ++i) {
	        	output.add(i, 1);
	        	for(int j = i - 1; j > 0; --j) {
	        		output.set(j, output.get(j) + output.get(j - 1));
	        	}
	        }
    	}
        return output;
    }
}

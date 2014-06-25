package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * @author Mengchao Zhong
 */
public class PascalsTriangle {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generate(1));
		System.out.println(generate(8));
	}
	
	/**
	 * Solution.
	 * @param numRows
	 * @return
	 */
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> output = new ArrayList<List<Integer>>();
    	int line = 0;
    	if(numRows > 0) {
    		List<Integer> currentLine = new ArrayList<Integer>();
    		currentLine.add(1);
    		output.add(currentLine);
    	}
    	while(line + 1 < numRows) {
    		List<Integer> currentLine = new ArrayList<Integer>();
    		currentLine.add(1);
        	for(int i = 1; i < output.get(line).size(); ++i) {
        		currentLine.add(i, output.get(line).get(i - 1) + output.get(line).get(i));
        	}
        	currentLine.add(1);
        	output.add(currentLine);
        	line++;
    	}
    	return output;
    }
}

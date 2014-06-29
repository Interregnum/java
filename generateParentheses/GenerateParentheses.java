package generateParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @author Mengchao Zhong
 */
public class GenerateParentheses {

	/**
	 * Test cases.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(5));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
    	List<List<String>> dp = new ArrayList<List<String>>();
        if(n < 1) {
        	return output;
        }
        output.add("()");
        dp.add(output);
        for(int i = 1; i < n; ++i) {
        	List<String> prev = dp.get(i - 1);
        	List<String> cur = new ArrayList<String>();
        	Map<String, String> table = new HashMap<String, String>();
        	for(String pattern : prev) {
        		for(int j = 0; j < pattern.length(); ++j) {
        			if(pattern.charAt(j) == '(') {
        				String leftLeft = pattern.substring(0, j);
        				String leftRight = pattern.substring(j);
        				String left1 = leftLeft + "()" + leftRight;
        				if(!table.containsKey(left1)) {
        					table.put(left1, left1);
        				}
        				String rightLeft = pattern.substring(0, j + 1);
        				String rightRight = pattern.substring(j + 1);
        				String left2 = rightLeft + "()" + rightRight;
        				if(!table.containsKey(left2)) {
        					table.put(left2, left2);
        				}
        			}
        			else {
        				String rightLeft = pattern.substring(0, j + 1);
        				String rightRight = pattern.substring(j + 1);
        				String right = rightLeft + "()" + rightRight;
        				if(!table.containsKey(right)) {
        					table.put(right, right);
        				}
        			}
        		}
        	}
        	Object[] tmp = table.values().toArray();
        	for(int k = 0; k < tmp.length; ++k) {
        		cur.add(tmp[k].toString());
        	}
        	dp.add(cur);
        }
        return dp.get(n - 1);
    }
}
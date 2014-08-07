package validParentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * @author Mengchao Zhong
 */
public class ValidParentheses {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isValid("((])[]{}"));
	}

	/**
	 * Solution.
	 * @param s
	 * @return
	 */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i) {
        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        		stack.push(s.charAt(i));
        	}
        	else {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		char cur = stack.pop();
        		switch(s.charAt(i)) {
        			case ')':
        				if(cur != '(') {
        					return false;
        				}
        				break;
        			case ']': 
        				if(cur != '[') {
        					return false;
        				}
        				break;
        			case '}': 
        				if(cur != '{') {
        					return false;
        				}
        				break;
        			default:
        				break;	
        		}
        	}
        }
        return stack.isEmpty();
    }
}

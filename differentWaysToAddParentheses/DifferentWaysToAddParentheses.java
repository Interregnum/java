package differentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * @author Mengchao Zhong
 */
public class DifferentWaysToAddParentheses {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}

	/**
	 * Solution.
	 * @param input
	 * @return
	 */
	public static List<Integer> output = new ArrayList<Integer>();
	
    public static List<Integer> diffWaysToCompute(String input) {
    	int[] operatorPos = new int[input.length()];
    	int operatorCount = 0;
    	
        for(int i = 0; i < input.length(); ++i) {
        	if(input.charAt(i) < 48) {
        		operatorPos[i] = input.charAt(i);
        		operatorCount++;
        	}
        }
        
        /*
         * Open Parentheses => -1
         * Close Parentheses => 1
         */
        int[][] parentheseState = new int[operatorCount][input.length()];
        putPars(parentheseState, 0, operatorCount, operatorPos, input);
        return output;
    }
    
    public static void putPars(int[][] parentheseState, int currCount, int operatorCount, int[] operatorPos, String input) {
    	if(currCount == operatorCount) {
    		int[] openParIndex = new int[operatorCount];
    		int[] closeParIndex = new int[operatorCount];
    		for(int i = 0; i < parentheseState.length; ++i) {
    			for(int j = 0; j < parentheseState[0].length; ++j) {
    				if(parentheseState[i][j] == -1) {
    					openParIndex[i] = j;
    				}
    				if(parentheseState[i][j] == 1) {
    					closeParIndex[i] = j;
    				}
    			}
    		}
    		Arrays.sort(openParIndex);
    		Arrays.sort(closeParIndex);
    		
    		// Start finding open parentheses reversely and see where it meets the first close parentheses.
    		for(int i = openParIndex.length - 1; i >= 0; --i) {
        		for(int j = 0; j < closeParIndex.length; ++j) {
        			if(closeParIndex[j] > openParIndex[i]) {
        				int calStart = openParIndex[i];
        				int calEnd = closeParIndex[j];
        				StringBuilder builder = new StringBuilder();
        				builder.append(input.substring(0, openParIndex[i]));
        				int val = calculate(input.substring(calStart, calEnd + 1));

        				// Append negative sign if necessary.
        				if(val < 0) {
        					builder.append("-");
        				}
        				
        				// Keep input string at same length so that we don't need to maintain the index matrix.
        				for(int k = 0; k < calEnd - calStart + 1 - Integer.toString(val).length(); ++k) {
        					builder.append(0);
        				}
        				builder.append(Math.abs(val));
        				if(closeParIndex[j] < input.length() - 1) {
        					builder.append(input.substring(closeParIndex[j] + 1));
        				}
        				input = builder.toString();
        				closeParIndex[j] = -1;
        				break;
        			}
        		}
        	}
    		
    		output.add(Integer.parseInt(input));
    	}
    	else {
    		for(int openIndex = 0; openIndex < operatorPos.length - 1; ++openIndex) {
				if(operatorPos[openIndex] == 0 
						&& (openIndex == 0 || operatorPos[openIndex - 1] != 0)
						&& isOpenParValidAtIndex(parentheseState, operatorPos, openIndex, currCount)) {
    					parentheseState[currCount][openIndex] = -1;
    					for(int closeIndex = openIndex; closeIndex < operatorPos.length; ++closeIndex) {
    						if(operatorPos[closeIndex] == 0 
    								&& (closeIndex == operatorPos.length - 1 || operatorPos[closeIndex + 1] != 0)
    								&& isCloseParValidAtIndex(parentheseState, operatorPos, openIndex, closeIndex, currCount)) {
    							parentheseState[currCount][closeIndex] = 1;
    							putPars(parentheseState, currCount + 1, operatorCount, operatorPos, input);
    							parentheseState[currCount][closeIndex] = 0;
    						}
    					}
    					parentheseState[currCount][openIndex] = 0;
				}
    		}
    	}
    }
    
    
    public static boolean isOpenParValidAtIndex(int[][] parentheseState, int[] operatorPos, int index, int count) {
    	// Find the next operator in the string.
    	int nextOperator = index;
    	for(; nextOperator < operatorPos.length; ++nextOperator) {
			if(operatorPos[nextOperator] > 0) {
				break;
			}
		}
    	
    	// Make sure we are not inserting an open parentheses to the end of string.
    	if(nextOperator != operatorPos.length) {
    		for(int i = 0; i < count; ++i) {
    			// Make sure a pair of parentheses contains not only number.
        		if(parentheseState[i][nextOperator - 1] == 1) {
        			return false;
        		}
        		// Remove duplicates.
        		for(int j = index + 1; j < parentheseState[i].length; ++j) {
        			if(parentheseState[i][j] == -1) {
        				return false;
        			}
        		}
        	}
    		return true;
    	}
    	return false;
    }
    
    public static boolean isCloseParValidAtIndex(int[][] parentheseState, int[] operatorPos, int open, int index, int count) {
    	// Find the previous operator in the string.
    	int prevOperator = index;
    	for(; prevOperator >= 0; --prevOperator) {
			if(operatorPos[prevOperator] > 0) {
				break;
			}
		}
    	
    	// Make sure we are not inserting a close parentheses to the beginning of string.
    	if(prevOperator > 0) {
    		for(int i = 0; i <= count; ++i) {
    			// Make sure a pair of parentheses contains not only number.
    			if(parentheseState[i][prevOperator + 1] == -1
    					//Remove duplicates.
        				|| (parentheseState[i][open] == -1 && parentheseState[i][index] == 1)) {
        			return false;
        		}
    			for(int j = index - 1; j >= open; --j) {
    				// Make sure the newly added close parentheses does not pair up with an unexpected open parentheses.
    				if(j > open && parentheseState[i][j] == -1) {
    					return false;
    				}
    				// Remove duplicates.
    				if(parentheseState[i][j] == 1) {
    					return false;
    				}
    			}
        	}
    		return true;
    	}
    	return false;
    }
    
    public static int calculate(String input) {
    	int left = 0;
    	int leftSign = 1;
    	int right = 0;
    	int rightSign = 1;
    	int operator = 0;
    	
    	for(int i = 0; i < input.length(); ++i) {
    		do {
    			// Check if the operand is a negative value.
    			if(input.charAt(i) == 45) {
    				leftSign = -1;
    				++i;
    			}
    			left = left * 10 + input.charAt(i) - 48;
    			++i;
    		} while(input.charAt(i) >= 48 && input.charAt(i) <= 57);
    		operator = input.charAt(i);
    		++i;
    		do {
    			// Check if the operand is a negative value.
    			if(input.charAt(i) == 45) {
    				rightSign = -1;
    				++i;
    			}
    			right = right * 10 + input.charAt(i) - 48;
    			++i;
    		} while(i < input.length());
    	}
    	
    	switch(operator) {
    		case 42:
    			return left * leftSign * right * rightSign;
    		case 43:
    			return left * leftSign + right * rightSign;
    		case 45:
    			return left * leftSign - right * rightSign;
			default:
    			return 0;
    	}
    }
}

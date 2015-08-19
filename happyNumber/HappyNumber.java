package happyNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * @author Mengchao Zhong
 */
public class HappyNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isHappy(1));
		System.out.println(isHappy(0));
		System.out.println(isHappy(7));
		System.out.println(isHappy(68));
		System.out.println(isHappy(86));
		System.out.println(isHappy(1102));
		System.out.println(isHappy(112));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static boolean isHappy(int n) {
        if(n == 0) {
        	return false;
        }
        if(n == 1) {
        	return true;
        }
    	
        Map<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        int sum = 0;
        
        while(sum != 1) {
        	sum = 0;
        	for( ;n > 0; n /= 10) {
            	sum += (n % 10) * (n % 10);
            }
        	
        	if(hash.containsKey(sum)) {
        		return false;
        	}
        	else {
        		hash.put(sum, true);
        	}
        	n = sum;
        }
        
        return true;
    }
}
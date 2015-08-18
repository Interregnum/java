package uglyNumber;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * @author Mengchao Zhong
 */
public class UglyNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
		System.out.println(isUgly(1));
		System.out.println(isUgly(0));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public static boolean isUgly(int num) {
    	if(num == 0) {
    		return false;
    	}
    	else if(num == 1) {
        	return true;
        }
        else if(num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
        	return false;
        }
        else if(num % 2 == 0) {
        	return isUgly(num / 2);
        }
        else if(num % 3 == 0) {
        	return isUgly(num / 3);
        }
        else {
        	return isUgly(num / 5);
        }
    }
}

package reverseInteger;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author Mengchao Zhong
 */
public class ReverseInteger {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(-24001));
		System.out.println(reverse(2710));
		System.out.println(reverse(0));
	}

	/**
	 * Solution.
	 * @param x
	 * @return
	 */
    public static int reverse(int x) {
        if(x >= 0) {
        	int y = 0;
        	while(x > 0) {
        		y = y * 10 + x % 10;
        		x = x / 10;
        	}
        	return y;
        }
        else {
        	return -reverse(-x);
        }
    }
}
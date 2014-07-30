package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class BinaryPalindrome {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(5) + " " + Integer.toBinaryString(5));
		System.out.println(isPalindrome(15) + " " + Integer.toBinaryString(15));
		System.out.println(isPalindrome(25) + " " + Integer.toBinaryString(25));
		System.out.println(isPalindrome(2523) + " " + Integer.toBinaryString(2523));
		System.out.println(isPalindrome(-25) + " " + Integer.toBinaryString(-25));
		System.out.println(isPalindrome(-15) + " " + Integer.toBinaryString(-15));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
	public static boolean isPalindrome(int num) {
		int reversed = 0;
		for(int tmp = num; tmp > 0; tmp >>= 1) {
			reversed = (reversed << 1) + tmp % 2;
		}
		return reversed == num;
	}
}

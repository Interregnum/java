package addDigits;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * @author Mengchao Zhong
 */
public class AddDigits {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addDigits(0));
		System.out.println(addDigits(238));
		System.out.println(addDigits(921));
		System.out.println(addDigits(36));
		System.out.println(addDigits2(0));
		System.out.println(addDigits2(238));
		System.out.println(addDigits2(921));
		System.out.println(addDigits2(36));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		while(num >= 10 || num <= -10) {
			int sum = 0;
        	while(num > 0) {
        		sum += num % 10;
        		num /= 10;
        	}
        	num = sum;
        }
		return num;
    }
	
	/**
	 * Solution 2: O(1).
	 * @param num
	 * @return
	 */
	public static int addDigits2(int num) {
		return 1 + (num - 1) % 9;
    }
}

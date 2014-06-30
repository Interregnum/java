package plusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author Mengchao Zhong
 */
public class PlusOne {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num1 = {1, 2, 3, 4, 5, 6, 7, 5, 3, 1};
		int[] num2 = {1, 2, 3, 4, 5, 6, 7, 5, 9, 9};
		int[] num3 = {9, 9, 9};
		System.out.println(plusOne(num1));
		System.out.println(plusOne(num2));
		System.out.println(plusOne(num3));
	}

	/**
	 * Solution.
	 * @param digits
	 * @return
	 */
    public static int[] plusOne(int[] digits) {
    	if(null == digits || digits.length == 0) {
    		return null;
    	}
        for(int i = digits.length - 1; i >= 0; --i) {
        	if(digits[i] + 1 == 10) {
        		digits[i] = 0;
        	}
        	else {
        		digits[i] += 1;
        		return digits;
        	}
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for(int j = 1; j < newDigits.length; ++j) {
        	newDigits[j] = digits[j - 1];
        }
        return newDigits;
    }
}

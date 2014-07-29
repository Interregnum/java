package palindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author Mengchao Zhong
 */
public class PalindromeNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome2(12345));
		System.out.println(isPalindrome2(123454321));
		System.out.println(isPalindrome2(12344321));
		System.out.println(isPalindrome2(222345));
	}
	
	/**
	 * Solution.
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(int x) {
        String original = Integer.toString(x);
        StringBuilder strBuilder = new StringBuilder(original);
        String reversed = strBuilder.reverse().toString();
        return original.equals(reversed);
    }
    
    /**
     * Solution: No Extra Space(Not Sure).
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
    	if(x < 0) {
    		return false;
    	}
    	long reversed = 0;
    	long original = x;
    	while(x / 10 > 0) {
    		reversed = 10 * reversed + x % 10;
    		x = x / 10;
    	}
    	reversed = 10 * reversed + x % 10;
    	return reversed == original;
    }
}

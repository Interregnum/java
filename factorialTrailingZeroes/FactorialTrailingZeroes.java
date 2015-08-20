package factorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * @author Mengchao Zhong
 */
public class FactorialTrailingZeroes {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(20));
		System.out.println(trailingZeroes(11));
		System.out.println(trailingZeroes(43));
		System.out.println(trailingZeroes(55));
		System.out.println(trailingZeroes(80));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static int trailingZeroes(int n) {
        int zeroes = 0;
        
    	while(n > 0) {
    		zeroes += n / 5;
    		n /= 5;
    	}
    	
    	return zeroes;
    }
}

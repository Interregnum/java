package numberOf1Bits;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * @author Mengchao Zhong
 */
public class NumberOf1Bits {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hammingWeight(10));
		System.out.println(hammingWeight(15));
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight(22));
		System.out.println(Integer.MAX_VALUE);
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				++count;
			}
			n = n >>> 1;
		}
		return count;
    }
}

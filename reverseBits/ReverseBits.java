package reverseBits;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * @author Mengchao Zhong
 */
public class ReverseBits {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(125) + " <-> " + Integer.toBinaryString(reverseBits(125)));
		System.out.println(Integer.toBinaryString(0) + " <-> " + Integer.toBinaryString(reverseBits(0)));
		System.out.println(Integer.toBinaryString(1) + " <-> " + Integer.toBinaryString(reverseBits(1)));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int reverse = 0;
    	for(int i = 0; i < 32; ++i) {
        	if((n & (1 << i)) != 0) {
        		reverse |= 1 << (31 - i);
        	}
        }
    	return reverse;
    }
}

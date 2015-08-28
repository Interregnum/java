package bitwiseANDOfNumbersRange;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * @author Mengchao Zhong
 */
public class BitwiseANDOfNumbersRange {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(28 << 2);
		System.out.println(rangeBitwiseAnd(5, 7));
		System.out.println(rangeBitwiseAnd(5, 8));
	}

	/**
	 * Solution.
	 * @param m
	 * @param n
	 * @return
	 */
    public static int rangeBitwiseAnd(int m, int n) {
        int diff = n - m;
        int bits = 0;
        for(int i = 0; i < 32; ++i) {
        	if(((diff >> i) & 1) != 0) {
        		bits = i + 1;
        	}
        }
        return m & n & (-1 << bits);
    }
    
    /**
     * Solution: Better.
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd2(int m, int n) {
        int diff = 0;
        while(m != n) {
        	m >>= 1;
        	n >>= 1;
			++diff;
        }
        return n << diff;
    }
}

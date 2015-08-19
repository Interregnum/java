package powerOfTwo;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Mengchao Zhong
 */
public class PowerOfTwo {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(4));
		System.out.println(isPowerOfTwo(8));
		System.out.println(isPowerOfTwo(1024));
		System.out.println(isPowerOfTwo(5));
		System.out.println(isPowerOfTwo(1230124));
		System.out.println(isPowerOfTwo2(0));
		System.out.println(isPowerOfTwo2(1));
		System.out.println(isPowerOfTwo2(2));
		System.out.println(isPowerOfTwo2(4));
		System.out.println(isPowerOfTwo2(8));
		System.out.println(isPowerOfTwo2(1024));
		System.out.println(isPowerOfTwo2(5));
		System.out.println(isPowerOfTwo2(1230124));
	}
	
	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static boolean isPowerOfTwo(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	
        int count = 0;
    	for(int i = 0; i < 32; ++i) {
    		if((n & (1 << i)) != 0) {
    			++count;
    		}
    	}
    	
    	return count == 1;
    }
    
	/**
	 * Solution: Nicer.
	 * @param n
	 * @return
	 */
    public static boolean isPowerOfTwo2(int n) {
    	return n <= 0 ? false : (n & -n) == n;
    }
}

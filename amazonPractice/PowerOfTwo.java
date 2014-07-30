package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class PowerOfTwo {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(divideByTwo(0));
		System.out.println(divideByTwo(-8));
		System.out.println(divideByTwo(1));
		System.out.println(divideByTwo(256));
		System.out.println(divideByTwo(13));
		System.out.println(divideByTwo(24));
		System.out.println(countOnes(0));
		System.out.println(countOnes(-8));
		System.out.println(countOnes(1));
		System.out.println(countOnes(256));
		System.out.println(countOnes(13));
		System.out.println(countOnes(24));
		System.out.println(decrement(0));
		System.out.println(decrement(-8));
		System.out.println(decrement(1));
		System.out.println(decrement(256));
		System.out.println(decrement(13));
		System.out.println(decrement(24));
		System.out.println(complement(0));
		System.out.println(complement(-8));
		System.out.println(complement(1));
		System.out.println(complement(256));
		System.out.println(complement(13));
		System.out.println(complement(24));
	}

	/**
	 * Solution: Divide By Two.
	 * @param num
	 * @return
	 */
	public static boolean divideByTwo(int num) {
		if(num == 0 || num == 1) {
			return true;
		}
		if(num < 0) {
			return false;
		}
		for(; num > 1; num /= 2) {
			if(num % 2 != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Solution: Count Ones.
	 * @param num
	 * @return
	 */
	public static boolean countOnes(int num) {
		if(num < 0) {
			return false;
		}
		if(num == 0) {
			return true;
		}
		int count = 0;
		for(; num > 0; num >>= 1) {
			if(num % 2 == 1) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Solution: Decrement.
	 * @param num
	 * @return
	 */
	public static boolean decrement(int num) {
		if(num < 0) {
			return false;
		}
		return (num & num - 1) == 0;
	}
	
	/**
	 * Solution: Complement.
	 * @param num
	 * @return
	 */
	public static boolean complement(int num) {
		if(num < 0) {
			return false;
		}
		return (num & (~num + 1)) == num;
	}
}

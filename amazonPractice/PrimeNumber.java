package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class PrimeNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPrimeNumber(7));
		System.out.println(isPrimeNumber(8));
		System.out.println(isPrimeNumber(11));
		System.out.println(isPrimeNumber(13));
		System.out.println(isPrimeNumber(17));
		System.out.println(isPrimeNumber(25));
		System.out.println(isPrimeNumber(77));
		System.out.println(isPrimeNumber(97));
	}

	/**
	 * Solution: 2 ~ Sqrt
	 * @param num
	 * @return
	 */
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i <= Math.sqrt(num); ++i) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

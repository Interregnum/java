package powXN;

/**
 * Implement pow(x, n).
 * @author Mengchao Zhong
 */
public class PowXN {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(pow(1.5, 0));
		System.out.println(pow(2.0, -5));
		System.out.println(pow(3.1, 7));
		System.out.println(pow(0, 10));
	}
	
	/**
	 * Solution.
	 * @param x
	 * @param n
	 * @return
	 */
    public static double pow(double x, int n) {
    	if(n == 0) {
        	return 1;
        }
    	else {
    		int k = Math.abs(n);
    		double bin = pow(x, k / 2);
    		double ans =  bin * bin * (k % 2 == 1 ? x : 1);
    		return  n > 0 ? ans : 1 / ans;
    	}
    }
}

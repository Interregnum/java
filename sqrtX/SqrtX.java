package sqrtX;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author Mengchao Zhong
 */
public class SqrtX {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(mySqrt(0));
		System.out.println(mySqrt(22));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(1));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(21984916));
		System.out.println(mySqrt(31413));
		System.out.println(mySqrt(149191));
	}

	/**
	 * Solution.
	 * @param x
	 * @return
	 */
    public static int mySqrt(int x) {
        if(x < 0) {
        	return -1;
        }
        else if(x < 2) {
        	return x;
        }
        else {
        	double curr = 0;
        	double next = 2;
        	while(Math.abs(next - curr) >= 1.0) {
        		curr = next;
        		next = (curr + x / curr) / 2;
        	}
        	return (int) Math.floor(next);
        }
    }
}

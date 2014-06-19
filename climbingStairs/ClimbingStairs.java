package climbingStairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Mengchao Zhong
 */
public class ClimbingStairs {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(10));
		System.out.println(climbStairs(100));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	if(n < 2) {
    		return n;
    	}
        int[] permutation = new int[n + 1];
        permutation[0] = 0;
        permutation[1] = 1;
        permutation[2] = 2;
        for(int i = 3; i <= n; ++i) {
        	permutation[i] = permutation[i - 1] + permutation[i - 2];
        }
        return permutation[n];
    }
}
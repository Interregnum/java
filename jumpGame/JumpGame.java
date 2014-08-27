package jumpGame;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * @author Mengchao Zhong
 */
public class JumpGame {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {2, 3, 1, 1, 4};
		int[] array2 = {3, 2, 1, 0, 4};
		int[] array3 = {4, 0, 0, 0, 2, 0, 1};
		int[] array4 = {0};
		System.out.println(canJump2(array1));
		System.out.println(canJump2(array2));
		System.out.println(canJump2(array3));
		System.out.println(canJump2(array4));
	}

	/**
	 * Solution.
	 * @param A
	 * @return
	 */
    public static boolean canJump(int[] A) {
        for(int i = 0; i < A.length - 1; ++i) {
        	if(A[i] == 0) {
        		int j = i - 1;
        		int back = 0;
        		while(j >= 0) {
        			++back;
        			if(A[j] > back) {
        				break;
        			}
        			--j;
        		}
        		if(j < 0) {
        			return false;
        		}
        	}
        }
        return true;
    }

    /**
     * Solution: Backward.
     * @param A
     * @return
     */
    public static boolean canJump2(int[] A) {
    	int last = A.length - 1;
    	for(int i = A.length - 2; i >= 0; --i) {
    		if(last - i <= A[i]) {
    			last = i;
    		}
        }
        return 0 == last;
    }
}

package singleNumberII;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * @author Mengchao Zhong
 */
public class SingleNumberII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 3, 4, 5, 4, 3, 5, 5, 3, 4};
		System.out.println(singleNumber(array));
	}

	/**
	 * Solution.
	 * @param A
	 * @return
	 */
    public static int singleNumber(int[] A) {
        int number = 0;
    	for(int i = 0; i < 32; ++i) {
        	int count = 0;
        	for(int j = 0; j < A.length; ++j) {
        		if((A[j] & (1 << i)) == 0) {
        			count++;
        		}
        	}
        	if(count % 3 == 0) {
        		number |= (1 << i);
        	}
        }
    	return number;
    }
}

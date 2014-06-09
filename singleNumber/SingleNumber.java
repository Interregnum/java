package singleNumber;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * @author Mengchao Zhong
 */
public class SingleNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 1};
		System.out.println(singleNumber(numbers));
	}
	
	/**
	 * Solution.
	 * @param A
	 * @return
	 */
    public static int singleNumber(int[] A) {
        int number = 0;
    	
    	for(int i = 0; i < A.length; ++i) {
        	number ^= A[i];
        }
    	
    	return number;
    }
}
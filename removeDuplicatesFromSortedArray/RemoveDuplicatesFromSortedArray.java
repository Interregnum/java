package removeDuplicatesFromSortedArray;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * @author Mengchao Zhong
 */
public class RemoveDuplicatesFromSortedArray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {1, 1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9, 9};
		int[] array2 = {1, 1, 1, 1, 1, 1, 1, 1, 10};
		System.out.println(removeDuplicates(array1));
		System.out.println(removeDuplicates(array2));
	}

	/**
	 * Solution.
	 * @param A
	 * @return
	 */
    public static int removeDuplicates(int[] A) {
    	if(null == A || A.length == 0) {
    		return 0;
    	}
    	int count = 0;
    	for(int i = 1; i < A.length; ++i) {
    		if(A[i] != A[i - 1]) {
    			A[++count] = A[i];
    		}
    	}
    	return count + 1;
    }
}

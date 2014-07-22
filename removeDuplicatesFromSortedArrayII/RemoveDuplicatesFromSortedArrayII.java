package removeDuplicatesFromSortedArrayII;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * @author Mengchao Zhong
 */
public class RemoveDuplicatesFromSortedArrayII {

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
        int index = 0;
        boolean first = true;
        for(int i = 1; i < A.length; ++i) {
        	if(A[i] == A[i - 1] && first) {
        		first = false;
        		A[++index] = A[i];
        	}
        	else if(A[i] == A[i - 1] && !first) {
        		continue;
        	}
        	else {
        		first = true;
        		A[++index] = A[i];
        	}
        }
        return index + 1;
    }
}

package removeElement;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author Mengchao Zhong
 */
public class RemoveElement {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {1, 3, 1, 2, 3, 12, 3, 4, 5, 6, 1, 33, 3};
		int[] array2 = {3, 3, 1, 3, 1, 2, 3, 12, 3, 4, 5, 6, 1, 33, 3};
		System.out.println(removeElement(array1, 3));
		System.out.println(removeElement2(array2, 3));
	}

	/**
	 * Solution: Basic.
	 * @param A
	 * @param elem
	 * @return
	 */
    public static int removeElement(int[] A, int elem) {
        int count = 0;
    	for(int i = 0; i < A.length - count; ++i) {
    		if(elem == A[i]) {
    			for(int j = i; j < A.length - count - 1; ++j) {
    				A[j] = A[j + 1];
    			}
    			count++;
    			i--;
    		}
        }
    	return A.length - count;
    }
    
    /**
     * Solution: Faster.
     * @param A
     * @param elem
     * @return
     */
    public static int removeElement2(int[] A, int elem) {
    	int count = 0;
    	for(int i = 0; i < A.length; ++i) {
    		if(elem != A[i]) {
    			A[count++] = A[i];
    		}
    	}
    	return count;
    }
}
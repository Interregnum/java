package medianOfTwoSortedArrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author Mengchao Zhong
 */
public class MedianOfTwoSortedArrays {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {1, 3, 4, 5};
		int[] array2 = {2, 5, 6};
		System.out.println(findMedianSortedArrays(array1, array2));
	}

	/**
	 * Solution: Merge.
	 * @param A
	 * @param B
	 * @return
	 */
    public static double findMedianSortedArrays(int A[], int B[]) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] C = new int[A.length + B.length];
        while(a < A.length && b < B.length) {
        	if(A[a] < B[b]) {
        		C[c++] = A[a++];
        	}
        	else {
        		C[c++] = B[b++];
        	}
        }
        while(a < A.length) {
        	C[c++] = A[a++];
        }
        while(b < B.length) {
        	C[c++] = B[b++];
        }
        return C.length % 2 == 1 ? C[(C.length - 1) / 2] : (C[C.length / 2] + C[C.length / 2 - 1]) / 2.0;
    }
    
    /**
     * Solution: O(log(m + n)).
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays2(int A[], int B[]) {
    	
    }
}

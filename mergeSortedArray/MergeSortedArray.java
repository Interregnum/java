package mergeSortedArray;


/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * @author Mengchao Zhong
 */
public class MergeSortedArray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
    public void merge(int A[], int m, int B[], int n) {
    	if(null == A || null == B || n == 0) {
    		return;
    	}
    	if(m == 0) {
    	    for(int x = 0; x < n; ++x) {
    	        A[x] = B[x];
    	    }
    	    return;
    	}
    	for(int i = 0; i < m; ++i) {
    		A[m + n - 1 - i] = A[m - 1 - i];
    	}
    	int count = 0;
    	int a = 0;
    	int b = 0;
    	while(a < m && b < n) {
    		if(A[a + n] >= B[b]) {
    			A[count++] = B[b++];
    		}
    		else {
    			A[count++] = A[n + a++];
    		}
    	}
    	while(b < n) {
    	    A[count++] = B[b++];
    	}
    }
    
    /**
     * Solution: Better.
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int A[], int m, int B[], int n) {
    	int count = m + n;
    	int a = m;
    	int b = n;
    	while(b > 0) {
    		if(a > 0 && A[a - 1] >= B[b - 1]) {
    			A[--count] = A[--a];
    		}
    		else {
    			A[--count] = B[--b];
    		}
    	}
    }
}

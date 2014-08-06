package searchInRotatedSortedArrayII;

/**
 * What if duplicates are allowed?
 * Write a function to determine if a given target is in the array.
 * @author Mengchao Zhong
 */
public class SearchInRotatedSortedArrayII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {3, 1, 1};
		System.out.println(search(array1, 3));
	}

	/**
	 * Solution.
	 * @param A
	 * @param target
	 * @return
	 */
    public static boolean search(int[] A, int target) {
        int lower = 0;
        int upper = A.length - 1;
        while(lower <= upper) {
        	int middle = lower + (upper - lower) / 2;
        	if(A[middle] == target) {
        		return true;
        	}
        	if(A[middle] > A[lower]) {
        		if(target < A[middle] && target >= A[lower]) {
        			upper = middle - 1;
        		}
        		else {
        			lower = middle + 1;
        		}
        	}
        	else if(A[middle] < A[lower]) {
        		if(target > A[middle] && target <= A[upper]) {
        			lower = middle + 1;
        		}
        		else {
        			upper = middle - 1;
        		}
        	}
        	else {
        		++lower;
        	}
        }
        return false;
    }
}

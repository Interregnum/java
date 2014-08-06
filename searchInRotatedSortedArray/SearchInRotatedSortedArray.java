package searchInRotatedSortedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author Mengchao Zhong
 */
public class SearchInRotatedSortedArray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 1, 2, 3, 4, 5};
		int[] array2 = {1, 3};
		System.out.println(search(array1, 0));
		System.out.println(search(array2, 1));
	}

	/**
	 * Solution.
	 * @param A
	 * @param target
	 * @return
	 */
    public static int search(int[] A, int target) {
        int lower = 0;
        int upper = A.length;
        while(lower < upper - 1) {
        	int middle = lower + (upper - lower - 1) / 2;
        	if(A[middle] <= A[A.length - 1]) {
        		upper = middle + 1;
        	}
        	else {
        		lower = middle + 1;
        	}
        }
        upper = lower + A.length - 1;
        while(lower <= upper) {
        	int middle = lower + (upper - lower) / 2;
        	if(A[middle % A.length] == target) {
        		return middle;
        	}
        	else if(A[middle % A.length] > target) {
        		upper = middle - 1;
        	}
        	else {
        		lower = middle + 1;
        	}
        }
        return -1;
    }
}

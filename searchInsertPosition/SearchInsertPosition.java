package searchInsertPosition;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @author Mengchao Zhong
 */
public class SearchInsertPosition {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedArray = {-1, 2, 4, 6, 7, 8, 11, 14, 55, 123, 192, 212};
		System.out.println(searchInsert(sortedArray, 0));
		System.out.println(searchInsert(sortedArray, 14));
		System.out.println(searchInsert(sortedArray, 131));
		System.out.println(searchInsert(sortedArray, 250));
		System.out.println(searchInsert2(sortedArray, 0));
		System.out.println(searchInsert2(sortedArray, 14));
		System.out.println(searchInsert2(sortedArray, 131));
		System.out.println(searchInsert2(sortedArray, 250));
	}

	/**
	 * Solution.
	 * @param A
	 * @param target
	 * @return
	 */
    public static int searchInsert(int[] A, int target) {
    	for(int i = 0; i < A.length; ++i) {
        	if(target > A[i]) {
        		continue;
        	}
        	else {
        		return i;
        	}
        }
    	return A.length;
    }
    
    /**
     * Solution: Binary search.
     * @param A
     * @param target
     * @return
     */
    public static int searchInsert2(int[] A, int target) {
    	int lowerBound = 0;
    	int upperBound = A.length - 1;
    	
    	while(upperBound - lowerBound > 0) {
    		int mid = (lowerBound + upperBound) / 2;
    		if(A[mid] >= target) {
    			upperBound = mid;
    		}
    		else {
    			lowerBound = mid + 1;
    		}
    	}
    	
    	return A[lowerBound] >= target ? lowerBound : lowerBound + 1;
    }
}

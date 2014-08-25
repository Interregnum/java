package searchForARange;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * @author Mengchao Zhong
 */
public class SearchForARange {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {5, 7, 7, 8, 8, 10};
		System.out.println(searchRange(array1, 8));
	}

	/**
	 * Solution.
	 * @param A
	 * @param target
	 * @return
	 */
    public static int[] searchRange(int[] A, int target) {
        int[] output = new int[2];
    	int lower = 0;
        int upper = A.length;
        
        while(lower < upper - 1) {
        	int middle = lower + (upper - 1 - lower) / 2;
        	if(A[middle] >= target) {
        		upper = middle + 1;
        	}
        	else {
        		lower = middle + 1;
        	}
        }
        output[0] = A[lower] == target ? lower : -1;
        
        lower = 0;
        upper = A.length;
        
        while(lower < upper - 1) {
        	int middle = lower + (upper - lower) / 2;
        	if(A[middle] <= target) {
        		lower = middle;
        	}
        	else {
        		upper = middle;
        	}
        }
        output[1] = A[lower] == target ? lower : -1;
        
        return output;
    }	
}

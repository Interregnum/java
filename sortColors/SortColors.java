package sortColors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author Mengchao Zhong
 */
public class SortColors {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test1 = {0, 2, 1, 2, 1, 0, 0, 2, 1, 1};
		sortColors(test1);
		int[] test2 = {0, 2, 1, 2, 1, 0, 0, 2, 1, 1, 2, 0, 0, 0, 1};
		sortColors2(test2);
	}

	/**
	 * Solution.
	 * @param A
	 */
    public static void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
    	for(int i = 0; i < A.length; ++i) {
        	if(A[i] == 0) {
        		++red;
        	}
        	if(A[i] == 1) {
        		++white;
        	}
        	if(A[i] == 2) {
        		++blue;
        	}
        }
    	for(int j = 0; j < A.length; ++j) {
    		if(red-- > 0) {
    			A[j] = 0;
    			continue;
    		}
    		if(white-- > 0) {
    			A[j] = 1;
    			continue;
    		}
    		if(blue-- > 0) {
    			A[j] = 2;
    			continue;
    		}
    	}
    }
    
    private static int[] clone;
    
    /**
     * Solution: One Iteration.
     * @param A
     */
    public static void sortColors2(int[] A) {
    	clone = A;
    	int red = 0;
    	int white = 0;
    	int blue = A.length - 1;
    	
    	while(white <= blue) {
    		if(A[white] == 0) {
    			swap(red++, white++);
    		}
    		else if(A[white] == 1) {
    			white++;
    		}
    		else {
    			swap(blue--, white);
    		}
    	}
    }
    
    public static void swap(int num1, int num2) {
    	int tmp = clone[num2];
    	clone[num2] = clone[num1];
    	clone[num1] = tmp;
    }
}
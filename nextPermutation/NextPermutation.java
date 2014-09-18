package nextPermutation;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * @author Mengchao Zhong
 */
public class NextPermutation {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 4, 1};
		nextPermutation(array);
	}

	/**
	 * Solution.
	 * @param num
	 */
    public static void nextPermutation(int[] num) {
        for(int i = num.length - 1; i > 0; --i) {
        	if(num[i] > num[i - 1] || i == 1) {
        		for(int j = i; j < num.length - 1; ++j) {
            		for(int k = num.length - 1; k > j; --k) {
            			int tmp = num[k];
            			num[k] = num[k - 1];
            			num[k - 1] = tmp;
            		}
        		}
        		if(num[i - 1] >= num[num.length - 1]) {
        			for(int l = 0; l < num.length - 1; ++l) {
        				int tmp = num[l];
            			num[l] = num[l + 1];
            			num[l + 1] = tmp;
        			}
        		}
        		else {
        			for(int l = i; l < num.length; ++l) {
        				if(num[i - 1] < num[l]) {
            				int tmp = num[l];
                			num[l] = num[i - 1];
                			num[i - 1] = tmp;
                			break;
        				}
        			}
        		}
        		break;
        	}
        }
    }
}

package missingNumber;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * @author Mengchao Zhong
 */
public class MissingNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0, 1, 2, 3, 5}));
		System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 7, 8, 9, 10}));
		System.out.println(missingNumber(new int[]{1}));
		System.out.println(missingNumber(new int[]{0}));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int missingNumber(int[] nums) {
        long sum = 0;
        
        for(int i = 0; i < nums.length; ++i) {
        	sum += nums[i];
        }
        
        return (int) (nums.length * (nums.length + 1) / 2 - sum);
    }
}

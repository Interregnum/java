package productOfArrayExceptSelf;


/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * @author Mengchao Zhong
 */
public class ProductOfArrayExceptSelf {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4};
		int[] nums2 = {4, 2, 3, 1};
		int[] nums3 = {9, 0, -2};
		System.out.println(productExceptSelf(nums1));
		System.out.println(productExceptSelf(nums2));
		System.out.println(productExceptSelf(nums3));
		System.out.println(productExceptSelf2(nums1));
		System.out.println(productExceptSelf2(nums2));
		System.out.println(productExceptSelf2(nums3));
	}
	
	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf(int[] nums) {
        int[] productsForward = new int[nums.length];
        int[] productsBackward = new int[nums.length];
        int[] products = new int[nums.length];
        productsBackward[nums.length - 1] = 1;
        productsForward[0] = 1;
    	for(int i = nums.length - 1; i >= 1; --i) {
    		productsBackward[i - 1] = productsBackward[i] * nums[i];
    		productsForward[nums.length - i] = productsForward[nums.length - i - 1] * nums[nums.length - i - 1];
        }
    	for(int i = 0; i < nums.length; ++i) {
    		products[i] = productsForward[i] * productsBackward[i];
    	}
    	return products;
    }
    
	/**
	 * Solution: Constant Space.
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf2(int[] nums) {
        int[] products = new int[nums.length];
        int value = 1;
        
        products[nums.length - 1] = 1;
    	for(int i = 1; i < nums.length; ++i) {
    		products[nums.length - 1 - i] = products[nums.length - i] * nums[nums.length - i];
    	}
    	
    	for(int i = 0; i < nums.length; ++i) {
    		products[i] *= value;
    		value *= nums[i];
    	}
    	
    	return products;
    }
}

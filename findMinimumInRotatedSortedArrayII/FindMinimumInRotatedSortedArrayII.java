package findMinimumInRotatedSortedArrayII;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * The array may contain duplicates.
 * @author Mengchao Zhong
 */
public class FindMinimumInRotatedSortedArrayII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 1, 1, 1, 1, 1, 1};
		int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
		int[] nums3 = {4, 1, 1, 1, 1, 1, 1};
		int[] nums4 = {2, 2, 3, 4, 5, 0, 1};
		int[] nums5 = {3, 3, 1, 3};
		System.out.println(findMin(nums1));
		System.out.println(findMin(nums2));
		System.out.println(findMin(nums3));
		System.out.println(findMin(nums4));
		System.out.println(findMin(nums5));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int findMin(int[] nums) {
    	int start = 0;
    	int end = nums.length - 1;
    	
    	while(start < end) {
    		int mid = start + (end - start) / 2;
    		if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
    			++start;
    		}
    		else if(nums[mid] >= nums[start] && nums[mid] <= nums[end]) {
    			return nums[start];
    		}
    		else if(nums[mid] >= nums[start] && nums[mid] >= nums[end]) {
    			start = mid + 1;
    		}
    		else {
    			end = mid;
    		}
    	}
    	
    	return nums[start];
    }
}
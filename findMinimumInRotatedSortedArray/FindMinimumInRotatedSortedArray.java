package findMinimumInRotatedSortedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * @author Mengchao Zhong
 */
public class FindMinimumInRotatedSortedArray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
		int[] nums2 = {0, 1, 2, 4, 5, 6, 7};
		int[] nums3 = {7, 0, 1, 2, 4, 5, 6};
		int[] nums4 = {4, 5, 6, 7, 0, 1, 2, 3};
		int[] nums5 = {0, 1, 2, 3, 4, 5, 6, 7};
		int[] nums6 = {7, 0, 1, 2, 3, 4, 5, 6};
		System.out.println(findMin(nums1));
		System.out.println(findMin(nums2));
		System.out.println(findMin(nums3));
		System.out.println(findMin(nums4));
		System.out.println(findMin(nums5));
		System.out.println(findMin(nums6));
	}

	/**
	 * Solution.
	 * Refined code according to https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
	 * @param nums
	 * @return
	 */
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
        	int mid = start + (end - start) / 2;
        	if(nums[mid] >= nums[start] && nums[mid] >= nums[end]) {
        		start = mid + 1;
        	}
        	else if(nums[mid] <= nums[start] && nums[mid] <= nums[end]) {
        		end = mid;
        	}
        	else {
        		return nums[start];
        	}
        }
        return nums[end];
    }
}

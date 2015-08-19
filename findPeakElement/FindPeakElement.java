package findPeakElement;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] != num[i+1], find a peak element and return its index.
 * @author Mengchao Zhong
 */
public class FindPeakElement {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 4};
		int[] nums2 = {5, 3, 2, 1};
		int[] nums3 = {1, 2, 3, 4};
		int[] nums4 = {5, 1, 4, 3};
		System.out.println(findPeakElement(nums1));
		System.out.println(findPeakElement(nums2));
		System.out.println(findPeakElement(nums3));
		System.out.println(findPeakElement(nums4));
		System.out.println(findPeakElement2(nums1));
		System.out.println(findPeakElement2(nums2));
		System.out.println(findPeakElement2(nums3));
		System.out.println(findPeakElement2(nums4));
	}

	/**
	 * Solution.
	 * @param nums
	 * @return
	 */
    public static int findPeakElement(int[] nums) {
    	for(int i = 0; i < nums.length - 1; ++i) {
    		if(nums[i] > nums[i + 1]) {
    			return i;
    		}
    	}
    	return nums.length - 1;
    }

    /**
     * Solution: O(logN).
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
    	int start = 0;
    	int end = nums.length - 1;
    	
    	while(start < end) {
    		int mid = start + (end - start) / 2;
    		if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
    			end = mid;
    		}
    		else if(mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
    			start = mid + 1;
    		}
    	}
    	
    	return start;
    }
}

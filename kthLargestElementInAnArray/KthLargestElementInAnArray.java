package kthLargestElementInAnArray;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @author Mengchao Zhong
 */
public class KthLargestElementInAnArray {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 8, 12, 4, 3, 6, 9};
		int[] nums2 = {3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(findKthLargest(nums1, 3));
		System.out.println(findKthLargest(nums2, 8));
	}

	/**
	 * Solution.
	 * @param nums
	 * @param k
	 * @return
	 */
    public static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[nums.length];
    	for(int i = 0; i < nums.length; ++i) {
    		heap[i] = nums[i];
    		percolateUp(i, heap);
    	}
    	
    	int output = 0;
    	for(int i = heap.length, j = 0; i > 0 && j < k; --i, ++j) {
    		output = deleteMax(i, heap);
    	}
    	
    	return output;
    }
    
    public static void percolateUp(int heapSize, int[] heap) {
    	for(int i = heapSize; i > 0; i = (i - 1) / 2) {
    		if(heap[i] > heap[(i - 1) / 2]) {
    			int tmp = heap[i];
    			heap[i] = heap[(i - 1) / 2];
    			heap[(i - 1) / 2] = tmp;
    		}
    		else {
    			return;
    		}
    	}
    }
    
    public static int deleteMax(int heapSize, int[] heap) {
    	int max = heap[0];
    	int x = heap[heapSize - 1];
    	heap[heapSize - 1] = Integer.MIN_VALUE;
    	int i = 0;
    	
    	for(; i * 2 + 2 < heapSize; ) {
    		if(x > heap[i * 2 + 1] && x > heap[i * 2 + 2]) {
    			heap[i] = x;
    			break;
    		}
    		else if(heap[i * 2 + 1] > heap[i * 2 + 2]) {
    			heap[i] = heap[i * 2 + 1];
    			i = i * 2 + 1;
    		}
    		else {
    			heap[i] = heap[i * 2 + 2];
    			i = i * 2 + 2;
    		}
    	}
    	
    	heap[i] = x;
    	
    	return max;
    }
}

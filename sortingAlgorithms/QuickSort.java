package sortingAlgorithms;

/**
 * Implementation of Quick Sort.
 * @author Mengchao Zhong
 */
public class QuickSort {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {4, 5, 3, 2, 4, 6, 2, 4};
		quickSort(array1, 0, array1.length - 1);
	}
	
	/**
	 * Solution.
	 * @param array
	 * @param lower
	 * @param upper
	 */
	public static void quickSort(int[] array, int lower, int upper) {
		if(lower >= upper) {
			return;
		}
		
		int pivot = array[lower];
		int l = lower;
		int r = upper;
		while(l < r) {
			while(array[r] > pivot && l < r) {
				--r;
			}
			if(l < r) {
				array[l] = array[r];
				++l;
			}
			while(array[l] < pivot && l < r) {
				++l;
			}
			if(l < r) {
				array[r] = array[l];
				--r;
			}
		}
		array[l] = pivot;
		quickSort(array, lower, l - 1);
		quickSort(array, l + 1, upper);
	}
}

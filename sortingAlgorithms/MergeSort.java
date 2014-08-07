package sortingAlgorithms;

/**
 * Implementation of Merge Sort.
 * @author Mengchao Zhong
 */
public class MergeSort {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {4, 5, 3, 2, 4, 6, 2, 4};
		mergeSort(array1, 0, array1.length - 1);
	}

	/**
	 * Solution.
	 * @param array
	 * @param lower
	 * @param upper
	 */
	public static void mergeSort(int[] array, int lower, int upper) {
		if(lower >= upper) {
			return;
		}
		int middle = lower + (upper - lower) / 2;
		mergeSort(array, lower, middle);
		mergeSort(array, middle + 1, upper);
		int[] tmp = new int[upper - middle];
		for(int a = 0; a < upper - middle; ++a) {
			tmp[a] = array[middle + 1 + a];
		}
		int i = middle;
		int j = upper - middle - 1;
		int k = upper;
		while(i >= lower && j >= 0) {
			if(array[i] > tmp[j]) {
				array[k--] = array[i--];
			}
			else {
				array[k--] = tmp[j--];
			}
		}
		while(i >= lower) {
			array[k--] = array[i--];
		}
		while(j >= 0) {
			array[k--] = tmp[j--];
		}
	}
}

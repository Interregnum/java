package sortingAlgorithms;

/**
 * Implementation of Bubble Sort.
 * @author Mengchao Zhong
 */
public class BubbleSort {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {4, 5, 3, 2, 4, 6, 2, 4};
		bubbleSort(array1);
	}

	/**
	 * Swap two elements in the array.
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void swap(int[] array, int num1, int num2) {
		int tmp = array[num1];
		array[num1] = array[num2];
		array[num2] = tmp;
	}
	
	/**
	 * Solution.
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		for(int i = array.length - 1; i > 0; --i) {
			for(int j = 1; j <= i; ++j) {
				if(array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
	}
}

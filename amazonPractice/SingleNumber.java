package amazonPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class SingleNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {1, 99, 98, 1, 98, 99, 2, 2, 3, 3, 4, 4, 100, 5, 5, 6, 6, 7, 7};
		System.out.println(xor(array1));
		System.out.println(hashMap(array1));
	}

	/**
	 * Solution: XOR.
	 * @param numbers
	 * @return
	 */
	public static int xor(int[] numbers) {
		int num = 0;
		for(int i = 0; i < numbers.length; ++i) {
			num ^= numbers[i];
		}
		return num;
	}
	
	/**
	 * Solution: Hash Map.
	 * @param numbers
	 * @return
	 */
	public static int hashMap(int[] numbers) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; ++i) {
			if(map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			}
			else {
				map.put(numbers[i], 1);
			}
		}
		for(int i = 0; i < numbers.length; ++i) {
			if(map.get(numbers[i]) == 1) {
				return numbers[i];
			}
		}
		return 0;
	}
}

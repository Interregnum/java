package amazonPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class SumOfTwo {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(hashMap(18, nums));
		System.out.println(hashMap(9, nums));
		System.out.println(hashMap(19, nums));
		System.out.println(hashMap(2, nums));
		System.out.println(hashMap(11, nums));
	}

	/**
	 * Solution: Hash Map.
	 * @param sum
	 * @param array
	 * @return
	 */
	public static boolean hashMap(int sum, int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; ++i) {
			if(map.containsKey(sum - array[i])) {
				return true;
			}
			else {
				map.put(array[i], 1);
			}
		}
		return false;
	}
}

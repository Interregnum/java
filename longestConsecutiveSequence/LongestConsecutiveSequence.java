package longestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * @author Mengchao Zhong
 */
public class LongestConsecutiveSequence {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = {0, -1};
		System.out.println(longestConsecutive(array1));
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public static int longestConsecutive(int[] num) {
    	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    	int count = 0;
    	int max = 0;
    	for(int i = 0; i < num.length; ++i) {
    		if(map.containsKey(num[i] - 1) || map.containsKey(num[i] + 1)) {
    			map.put(num[i], true);
    			if(map.containsKey(num[i] - 1)) {
    				map.put(num[i] - 1, true);
    			}
    			else {
    				map.put(num[i] + 1 , true);
    			}
    		}
    		else {
    			map.put(num[i], false);
    		}
    	}
    	for(int i = 0; i < num.length; ++i) {
    		int j = 0;
    		while(map.get(num[i] - j)) {
    			if(j != 0) {
    				map.put(num[i] - j, false);
    			}
    			if(map.containsKey(num[i] - j - 1)) {
    				count++;
    				j++;
    			}
    			else {
    				break;
    			}
    		}
    		j = 0;
    		while(map.get(num[i] - j)) {
    			map.put(num[i] - j, false);
    			if(map.containsKey(num[i] - j + 1)) {
    				count++;
    				j--;
    			}
    			else {
    				break;
    			}
    		}
    		max = Math.max(max, ++count);
    		count = 0;
    	}
    	return max;
    }
}

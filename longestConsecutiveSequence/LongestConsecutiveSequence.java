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

	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public int longestConsecutive(int[] num) {
    	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    	int count = 0;
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
    			map.put(num[i] - j, false);
    			if(map.containsKey(num[i] - j)) {
    				count++;
    				j++;
    			}
    		}
    		j = -1;
    		while()
    	}
    }
}

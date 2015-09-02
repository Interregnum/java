package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * @author Mengchao Zhong
 */
public class GroupAnagrams {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

	/**
	 * Solution.
	 * @param strs
	 * @return
	 */
    public static List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        
    	for(int i = 0; i < strs.length; ++i) {
        	String str = strs[i];
        	int[] letters = new int[26];
        	for(int j = 0; j < str.length(); ++j) {
        		letters[str.charAt(j) - 'a']++;
        	}
        	
        	StringBuilder keyBuilder = new StringBuilder();
        	for(int j = 0; j < letters.length; ++j) {
        		if(letters[j] != 0) {
        			keyBuilder.append((char)(j + 'a'));
        			keyBuilder.append(letters[j]);
        		}
        	}
        	String key = keyBuilder.toString();
        	
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	}
        	map.get(key).add(strs[i]);
        }
    	
    	return new ArrayList<List<String>>(map.values());
    }
    
    /**
     * Solution 2.
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        
    	for(int i = 0; i < strs.length; ++i) {
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	String key = new String(chars);
        	
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	}
        	map.get(key).add(strs[i]);
        }
    	
    	return new ArrayList<List<String>>(map.values());
    }
}

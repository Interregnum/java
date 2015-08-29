package isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * @author Mengchao Zhong
 */
public class IsomorphicStrings {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("foo", "bar"));
	}

	/**
	 * Solution.
	 * @param s
	 * @param t
	 * @return
	 */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map  = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); ++i) {
        	if(map.containsKey(s.charAt(i))) {
        		char tChar = map.get(s.charAt(i));
        		if(tChar != t.charAt(i)) {
        			return false;
        		}
        	}
        	else if(map.containsValue(t.charAt(i))) {
        			return false;
    		}
    		else {
        			map.put(s.charAt(i), t.charAt(i));
    		}
        }
        return true;
    }
}

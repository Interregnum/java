package validAnagram;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * @author Mengchao Zhong
 */
public class ValidAnagram {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
		System.out.println(isAnagram("abcdefgh", "bcefgha"));
	}

	/**
	 * Solution.
	 * @param s
	 * @param t
	 * @return
	 */
    public static boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()) {
    		return false;
    	}
    	
    	int[] hash = new int[26];
    	
    	for(int i = 0; i < s.length(); ++i) {
    		hash[s.charAt(i) - 97] += 1;
    		hash[t.charAt(i) - 97] -= 1;
    	}
    	
    	for(int i = 0; i < hash.length; ++i) {
    		if(hash[i] != 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}

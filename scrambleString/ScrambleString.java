package scrambleString;

/**
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * @author Mengchao Zhong
 */
public class ScrambleString {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isScramble("cabccccbcacab", "caccbbacccbca"));
	}

	/**
	 * Solution.
	 * @param s1
	 * @param s2
	 * @return
	 */
    public static boolean isScramble(String s1, String s2) {
        if(s1.equals(s2) || s1.equals(new StringBuilder(s2).reverse().toString())) {
        	return true;
        }
        else {
    		boolean output = false;
    		for(int i = 0; i < s1.length() - 1; ++i) {
    			if(!output && isAnagram(s1.substring(0, i + 1), s2.substring(0, i + 1))
    					&& isAnagram(s1.substring(i + 1), s2.substring(i + 1))) {
    				output |= (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
    						&& isScramble(s1.substring(i + 1), s2.substring(i + 1)));
    			}
    		}
    		s2 = new StringBuilder(s2).reverse().toString();
    		for(int i = 0; i < s1.length() - 1; ++i) {
    			if(!output && isAnagram(s1.substring(0, i + 1), s2.substring(0, i + 1))
    					&& isAnagram(s1.substring(i + 1), s2.substring(i + 1))) {
    				output |= (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
    						&& isScramble(s1.substring(i + 1), s2.substring(i + 1)));
    			}
    		}
    		return output;
    	}
    }
    
    public static boolean isAnagram(String str1, String str2) {
		int[] count = new int[256];
		for(int i = 0; i < str1.length(); ++i) {
			count[str1.charAt(i)] += 1;
		}
		for(int i = 0; i < str2.length(); ++i) {
			if(count[str2.charAt(i)] == 0) {
				return false;
			}
			count[str2.charAt(i)] -= 1;
		}
		return true;
    }
}

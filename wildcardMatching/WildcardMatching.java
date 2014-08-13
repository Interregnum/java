package wildcardMatching;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * @author Mengchao Zhong
 */
public class WildcardMatching {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", "?*"));
		System.out.println(isMatch("abcccbccba", "a*ba"));
		System.out.println(isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}

	/**
	 * Solution: Recursion.
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) {
        	return true;
        }
        else if(s.isEmpty() || p.isEmpty()) {
        	return s.isEmpty() ? allStar(p) : false;
        }
        else {
        	int i = 0;
        	for(; i < s.length() && i < p.length(); ++i) {
        		if(s.charAt(i) != p.charAt(i)) {
        			if(p.charAt(i) == '?') {
        				continue;
        			}
        			else if(p.charAt(i) == '*') {
        				return isMatch(s.substring(i), p.substring(i + 1)) || isMatch(s.substring(i + 1), p.substring(i));
        			}
        			else {
        				return false;
        			}
        		}
        	}
        	return isMatch(s.substring(i), p.substring(i));
        }
    }
    
    public static int findFirstNonStar(String s) {
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) != '*') {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static int findFirstChar(String s, char c) {
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) == c) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static boolean allStar(String s) {
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) != '*') {
    			return false;
    		}
    	}
    	return true;
    }
}

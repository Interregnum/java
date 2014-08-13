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
		System.out.println(isMatch("aab", "c*a*b"));
	}

	/**
	 * Solution.
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) {
        	return true;
        }
        else if(s.isEmpty() || p.isEmpty()) {
        	return s.isEmpty() ? allStar(p) : allStar(s);
        }
        else {
            if(s.charAt(0) == p.charAt(0) || s.charAt(0) == '?' || p.charAt(0) == '?') {
            	return isMatch(s.substring(1), p.substring(1));
            }
        	else if(s.charAt(0) == '*' && p.charAt(0) == '*') {
        		int sIndex = findFirstNonStar(s);
        		int pIndex = findFirstNonStar(p);
        		if(sIndex == -1 || pIndex == -1) {
        			return true;
        		}
        		return isMatch(s.substring(sIndex), p) || isMatch(s, p.substring(pIndex));
        	}
            else if(s.charAt(0) == '*') {
            	int sIndex = findFirstNonStar(s);
            	if(sIndex == -1) {
            		return true;
            	}
            	int pIndex = findFirstChar(p, s.charAt(sIndex));
            	if(pIndex == -1) {
            		return false;
            	}
            	return isMatch(s.substring(sIndex), p.substring(pIndex));
            }
            else if(p.charAt(0) == '*') {
            	int pIndex = findFirstNonStar(p);
            	if(pIndex == -1) {
            		return true;
            	}
            	int sIndex = findFirstChar(s, p.charAt(pIndex));
            	if(sIndex == -1) {
            		return false;
            	}
            	return isMatch(s.substring(sIndex), p.substring(pIndex));
            }
        }
		return false;
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

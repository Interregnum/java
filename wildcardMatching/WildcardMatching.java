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
		System.out.println(isMatch2("aa", "a"));
		System.out.println(isMatch2("aa", "aa"));
		System.out.println(isMatch2("aaa", "aa"));
		System.out.println(isMatch2("aa", "*"));
		System.out.println(isMatch2("aa", "a*"));
		System.out.println(isMatch2("ab", "?*"));
		System.out.println(isMatch2("abcccbccba", "a*ba"));
		System.out.println(isMatch2("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
		System.out.println(isMatch2("aab", "c*a*b"));
	}

	/**
	 * Solution: Recursion - TLE.
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
    
    public static boolean allStar(String s) {
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) != '*') {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Solution: Dynamic Programming - MLE.
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    	int count = 0;
    	dp[0][0] = true;
    	for(int i = 1; i <= s.length(); ++i) {
    		dp[i][0] = false;
    	}
    	for(int j = 1; j <= p.length(); ++j) {
    		if(p.charAt(j - 1) != '*') {
    			count++;
    		}
    		dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
    	}
    	if(count > s.length()) {
    		return false;
    	}
    	for(int i = 1; i <= s.length(); ++i) {
    		for(int j = 1; j <= p.length(); ++j) {
    			if(p.charAt(j - 1) != '*') {
    				dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
    			}
    			else {
    				dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
}

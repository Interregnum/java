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
		System.out.println(isMatch3("aa", "a"));
		System.out.println(isMatch3("aa", "aa"));
		System.out.println(isMatch3("aaa", "aa"));
		System.out.println(isMatch3("aa", "*"));
		System.out.println(isMatch3("aa", "a*"));
		System.out.println(isMatch3("ab", "?*"));
		System.out.println(isMatch3("abcccbccba", "a*ba"));
		System.out.println(isMatch3("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
		System.out.println(isMatch3("aab", "c*a*b"));
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
    
    /**
     * Solution: Greedy.
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch3(String s, String p) {
    	if(s.isEmpty() && p.isEmpty()) {
    		return true;
    	}
    	
    	int starS = -1;
    	int starP = -1;
    	int indexS = 0;
    	int indexP = 0;
    	
    	while(indexS < s.length()) {
    		if(indexP < p.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
    			++indexS;
    			++indexP;
    		}
    		else if(indexP < p.length() && p.charAt(indexP) == '*') {
    			while(indexP < p.length() && p.charAt(indexP) == '*') {
    				++indexP;
    			}
    			if(indexP == p.length()) {
    				return true;
    			}
    			else {
    				starS = indexS;
    				starP = indexP;
    			}
    		}
    		else if((indexP >= p.length() || s.charAt(indexS) != p.charAt(indexP)) && starP != -1) {
    			indexS = ++starS;
    			indexP = starP;
    		}
    		else {
    			return false;
    		}
    	}
    	
    	while(indexP < p.length()) {
    		if(p.charAt(indexP) != '*') {
    			return false;
    		}
    		++indexP;
    	}
    	return true;
    }
}

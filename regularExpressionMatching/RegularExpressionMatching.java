package regularExpressionMatching;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * @author Mengchao Zhong
 */
public class RegularExpressionMatching {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMatch("a", ""));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("abcccbccba", "a*ba"));
//		System.out.println(isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}

	/**
	 * Solution.
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch(String s, String p) {
    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    	dp[0][0] = true;
    	if(p.length() > 0) {
    		dp[0][1] = false;
    	}
    	for(int i = 1; i <= s.length(); ++i) {
    		dp[i][0] = false;
    	}
    	for(int i = 2; i <= p.length(); ++i) {
    		dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
    	}
    	for(int i = 1; i <= s.length(); ++i) {
    		for(int j = 1; j <= p.length(); ++j) {
    			if(p.charAt(j - 1) != '*') {
    				dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
    			}
    			else {
    				dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) && dp[i - 1][j]);
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
}

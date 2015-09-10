package wordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * @author Mengchao Zhong
 */
public class WordBreak {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("meng");
		wordDict.add("chao");
		System.out.println(wordBreak2("mengchao", wordDict));
	}

	/**
	 * Solution: TLE.
	 * @param s
	 * @param wordDict
	 * @return
	 */
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.contains(s)) {
        	return true;
        }
        else {
        	for(int i = 1; i < s.length(); ++i) {
            	String firstHalf = s.substring(0, i);
            	String secondHalf = s.substring(i);
            	if(wordBreak(firstHalf, wordDict) && wordBreak(secondHalf, wordDict)) {
            		return true;
            	}
            }
        	return false;
        }
    }
    
    /**
     * Solution.
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, Set<String> wordDict) {
    	boolean[] dp = new boolean[s.length()];
    	for(int i = 0; i < s.length(); ++i) {
    		for(int j = 0; j <= i; ++j) {
    			String subStr = s.substring(j, i + 1);
    			
    			if(wordDict.contains(subStr) && (j == 0 || dp[j - 1])) {
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	return dp[s.length() - 1];
    }
}

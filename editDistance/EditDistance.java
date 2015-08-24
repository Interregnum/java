package editDistance;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author Mengchao Zhong
 */
public class EditDistance {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minDistance("kingburger", "burgerking"));
		System.out.println(minDistance("red", "green"));
	}

	/**
	 * Solution.
	 * @param word1
	 * @param word2
	 * @return
	 */
    public static int minDistance(String word1, String word2) {
    	int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    	
    	for(int i = 0; i <= word1.length(); ++i) {
    		dp[i][0] = i;
    	}
    	for(int j = 1; j <= word2.length(); ++j) {
    		dp[0][j] = j;
    	}
    	
    	for(int i = 1; i <= word1.length(); ++i) {
    		for(int j = 1; j <= word2.length(); ++j) {
    			if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1];
    			}
    			else {
    				int insert = dp[i][j - 1] + 1;
    				int delete = dp[i - 1][j] + 1;
    				int replace = dp[i - 1][j - 1] + 1;
    				
    				int iVr = insert < replace ? insert : replace;
    				int dVr = delete < replace ? delete : replace;
    				
    				dp[i][j] = iVr < dVr ? iVr : dVr; 
    			}
    		}
    	}
    	
    	return dp[word1.length()][word2.length()];
    }
}

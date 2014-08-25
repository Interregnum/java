package countAndSay;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * Given an integer n, generate the nth sequence.
 * @author Mengchao Zhong
 */
public class CountAndSay {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
		System.out.println(countAndSay(7));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        
        for(int i = 1; i < n; ++i) {
        	String tmp = dp[i - 1];
        	StringBuilder newWord = new StringBuilder();
        	int count = 1;
        	int j = 0;
        	for(; j < tmp.length() - 1;) {
        		if(tmp.charAt(j) == tmp.charAt(j + 1)) {
        			++count;
        			++j;
        			continue;
        		}
        		else {
        			newWord.append(count);
        			newWord.append(tmp.charAt(j));
        			++j;
        			count = 1;
        			continue;
        		}
        	}
        	newWord.append(count);
        	newWord.append(tmp.charAt(j));
        	dp[i] = newWord.toString();
        }
        
        return dp[n - 1];
    }
}

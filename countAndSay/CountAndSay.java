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
    	String dp = "1";
    	
        for(int i = 1; i < n; ++i) {
        	StringBuilder newWord = new StringBuilder();
        	int count = 1;
        	int j = 0;
        	for(; j < dp.length() - 1;) {
        		if(dp.charAt(j) == dp.charAt(j + 1)) {
        			++count;
        			++j;
        			continue;
        		}
        		else {
        			newWord.append(count);
        			newWord.append(dp.charAt(j));
        			++j;
        			count = 1;
        			continue;
        		}
        	}
        	newWord.append(count);
        	newWord.append(dp.charAt(j));
        	dp = newWord.toString();
        }
        
        return dp;
    }
}

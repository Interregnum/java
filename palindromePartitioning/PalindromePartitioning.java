package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * @author Mengchao Zhong
 */
public class PalindromePartitioning {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(partition("aabbaa"));
	}

	/**
	 * Solution.
	 * @param s
	 * @return
	 */
    public static List<List<String>> partition(String s) {
        iterate(s, 0, new ArrayList<String>());
        return output;
    }
    
    private static List<List<String>> output = new ArrayList<List<String>>();
    
    public static void iterate(String s, int start, List<String> partition) {
    	if(start >= s.length()) {
    		output.add(partition);
    		return;
    	}
    	for(int i = 0; i < s.length() - start; ++i) {
			if(isPalindrome(s, start, start + i)) {
				List<String> update = new ArrayList<String>(partition);
				update.add(s.substring(start, start + i + 1));
				iterate(s, start + i + 1, update);
			}
    	}
    }
    
    public static boolean isPalindrome(String s, int start, int end) {
    	for(int i = 0; i <= (end - start) / 2; ++i) {
    		if(s.charAt(i + start) != s.charAt(end - i)) {
    			return false;
    		}
    	}
    	return true;
    }
}

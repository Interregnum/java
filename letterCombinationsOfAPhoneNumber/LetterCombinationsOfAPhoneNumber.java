package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * @author Mengchao Zhong
 */
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	/**
	 * Solution.
	 * @param digits
	 * @return
	 */
    public static List<String> letterCombinations(String digits) {
        String[] dic = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<String>();
        output.add("");
        for(int i = 0; i < digits.length(); ++i) {
        	String cur = dic[digits.charAt(i) - 48];
        	List<String> tmp = new ArrayList<String>();
        	for(int j = 0; j < cur.length(); ++j) {
        		for(String s : output) {
        			tmp.add(s + cur.charAt(j));
        		}
        	}
        	output = tmp;
        }
        return output;
    }
}

package lengthOfLastWord;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * @author Mengchao Zhong
 */
public class LengthOfLastWord {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
			System.out.println(lengthOfLastWord("Hello World"));
			System.out.println(lengthOfLastWord(" "));
	}

	/**
	 * Solution.
	 * @param s
	 * @return
	 */
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }
}

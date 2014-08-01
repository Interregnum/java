package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class AnagramString {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hashArray("abcdefgfd", "agffeddbc"));
		System.out.println(hashArray("abcdefgfd", "agffeddbc1231"));
		System.out.println(hashArray("1*SHA", "1ISHa"));
	}

	/**
	 * Solution: Hash Array.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean hashArray(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		int[] count = new int[256];
		for(int i = 0; i < str1.length(); ++i) {
			count[str1.charAt(i)] += 1;
		}
		for(int i = 0; i < str2.length(); ++i) {
			if(count[str2.charAt(i)] == 0) {
				return false;
			}
			count[str2.charAt(i)] -= 1;
		}
		return true;
	}
}

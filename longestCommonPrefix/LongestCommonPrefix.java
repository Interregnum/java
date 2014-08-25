package longestCommonPrefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author Mengchao Zhong
 */
public class LongestCommonPrefix {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array1 = {"abb", "abc", "abd"};
		String[] array2 = {"abb", "abc", "bd"};
		String[] array3 = {"abccdb", "abccd", "abccddd"};
		System.out.println(longestCommonPrefix(array1));
		System.out.println(longestCommonPrefix(array2));
		System.out.println(longestCommonPrefix(array3));
	}

	/**
	 * Solution.
	 * @param strs
	 * @return
	 */
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length != 0) {
    		int index = 0;
    		while(index < strs[0].length()) {
    			for(int i = 1; i < strs.length; ++i) {
    				if(strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)) {
    					return strs[i].substring(0, index);
    				}
    				else {
    					continue;
    				}
    			}
    			++index;
    		}
    		return strs[0];
    	}
    	return "";
    }
}
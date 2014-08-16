package implementStrStr;

/**
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * @author Mengchao Zhong
 */
public class ImplementStrStr {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(strStr2("abasghd", "sgh"));
		System.out.println(strStr2("bbc abcdab abcdabcdabde", "abcdabd"));
	}

	/**
	 * Solution.
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public static String strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
        	return null;
        }
outer:
        for(int i = 0; i <= haystack.length() - needle.length(); ++i) {
        	for(int j = 0; j < needle.length(); ++j) {
        		if(haystack.charAt(i + j) != needle.charAt(j)) {
        			continue outer;
        		}
        	}
        	return haystack.substring(i);
        }
        return null;
    }
    
    /**
     * Solution: KMP.
     * @param haystack
     * @param needle
     * @return
     */
    public static String strStr2(String haystack, String needle) {
    	if(needle.length() > haystack.length()) {
    		return null;
    	}
    	int[] next = new int[needle.length() + 1];
    	next[0] = -1;
    	int k = -1;
    	int j = 0;
    	while(j < needle.length()) {
    		if(k == -1 || needle.charAt(j) == needle.charAt(k)) {
    			++j;
    			++k;
    			next[j] = k;
    		}
    		else {
    			k = next[k];
    		}
    	}
outer:
    	for(int i = 0; i <= haystack.length() - needle.length();) {
    		for(int l = 0; l < needle.length(); ++l) {
    			if(haystack.charAt(i + l) != needle.charAt(l)) {
    				i += l - next[l];
    				continue outer;
    			}
    		}
    		return haystack.substring(i);
    	}
    	return null;
    }
}

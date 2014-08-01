package amazonPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class FirstNonRepeatedCharacter {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(twoPass("geekForgeek"));
		System.out.println(twoPass("aswellas"));
		System.out.println(twoPass("geek"));
		System.out.println(twoPass("aabbccddeeffgghh"));
	}

	/**
	 * Solution: Two Pass.
	 * @param str
	 * @return
	 */
	public static char twoPass(String str) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < str.length(); ++i) {
			int tmp = str.charAt(i);
			map.put(tmp, map.get(tmp) == null ? 1 : 1 + map.get(tmp));
		}
		for(int i = 0; i < str.length(); ++i) {
			int tmp = str.charAt(i);
			if(map.get(tmp) == 1) {
				return (char) tmp;
			}
		}
		return ' ';
	}
}

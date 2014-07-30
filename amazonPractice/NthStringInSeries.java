package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class NthStringInSeries {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(nthStringInSeries(0));
		System.out.println(nthStringInSeries(17));
		System.out.println(nthStringInSeries(25));
		System.out.println(nthStringInSeries(26));
		System.out.println(nthStringInSeries(40));
		System.out.println(nthStringInSeries(675));
	}
	
	/**
	 * Solution.
	 * @param index
	 * @return
	 */
	public static String nthStringInSeries(int index) {
		if(index < 0) {
			return "";
		}
		if(index == 0) {
			return "A";
		}
		StringBuilder str = new StringBuilder();
		for(int i = index; i > 0; i /= 26) {
			str.append((char) (i % 26 + 65));
		}
		return str.toString();
	}
}

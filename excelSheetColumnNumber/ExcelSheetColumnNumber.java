package excelSheetColumnNumber;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * @author Mengchao Zhong
 */
public class ExcelSheetColumnNumber {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ZZ"));
		System.out.println(titleToNumber("AZC"));
	}

	/**
	 * Solution.
	 * @param s
	 * @return
	 */
    public static int titleToNumber(String s) {
    	int sum = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
        	int index = s.charAt(i) - 64;
        	int pow = s.length() - 1 - i;
        	while(pow-- > 0) {
        		index *= 26;
        	}
        	sum += index;
        }
        return sum;
    }
}
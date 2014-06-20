package integerToRoman;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author Mengchao Zhong
 */
public class IntegerToRoman {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(intToRoman(1320));
	}
	
	/**
	 * Solution.
	 * @param num
	 * @return
	 */
    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
    	
    	int M = num / 1000;
    	while(M-- > 0) {
    		sb.append("M");
    	}
        num = num % 1000;
        
        int C = num / 100;
    	int D = C / 5;
        if(D > 0 && C % 5 != 4) {
        	sb.append("D");
        }
        if(C % 5 != 4) {
        	int count = C % 5;
        	while(count-- > 0) {
        		sb.append("C");
        	}
        }
        else if(D > 0) {
        	sb.append("CM");
        }
        else {
        	sb.append("CD");
        }
        num = num % 100;
        
        int X = num / 10;
        int L = X / 5;
        if(L > 0 && X % 5 != 4) {
        	sb.append("L");
        }
        if(X % 5 != 4) {
            int count = X % 5;
        	while(count-- > 0) {
        		sb.append("X");
        	}
        }
        else if(L > 0) {
        	sb.append("XC");
        }
        else {
        	sb.append("XL");
        }
        num = num % 10;
        
        int I = num;
        int V = I / 5;
        if(V > 0 && I % 5 != 4) {
        	sb.append("V");
        }
        if(I % 5 != 4) {
            int count = I % 5;
        	while(count-- > 0) {
        		sb.append("I");
        	}
        }
        else if(V > 0) {
        	sb.append("IX");
        }
        else {
        	sb.append("IV");
        }
        return sb.toString();
    }
}

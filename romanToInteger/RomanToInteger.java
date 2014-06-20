package romanToInteger;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author Mengchao Zhong
 */
public class RomanToInteger {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(romanToInt("XXI"));
		System.out.println(romanToInt("MCDLXXVI"));
		System.out.println(romanToInt("LX"));
		System.out.println(romanToInt("MCM"));
		System.out.println(romanToInt("LXXXIX"));
	}

	/**
	 * Solution.
	 * @param s
	 * @return
	 */
    public static int romanToInt(String s) {
        int I = 0;
        int V = 0;
        int X = 0;
        int L = 0;
        int C = 0;
        int D = 0;
        int M = 0;
        for(int i = 0; i < s.length(); ++i) {
        	char roman = s.charAt(i);
        	switch(roman) {
	        	case 'I': 
	        		++I;
	        		break;
	        	case 'V':
	        		if(I != 0) {
	        			I -= 2;
	        		}
	        		++V;
	        		break;
	        	case 'X':
	        		if(I != 0) {
	        			I -= 2;
	        		}
	        		++X;
	        		break;
	        	case 'L':
	        		if(X != 0) {
	        			X -= 2;
	        		}
	        		++L;
	        		break;
	        	case 'C':
	        		if(X != 0) {
	        			X -= 2;
	        		}
	        		++C;
	        		break;
	        	case 'D':
	        		if(C != 0) {
	        			C -= 2;
	        		}
	        		++D;
	        		break;
	        	case 'M':
	        		if(C != 0) {
	        			C -= 2;
	        		}
	        		++M;
	        		break;
	        	default:
	        		throw new RuntimeException();	
        	}
        }
        return I * 1 + V * 5 + X * 10 + L * 50 + C * 100 + D * 500 + M * 1000;
    }
}

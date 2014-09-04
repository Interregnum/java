package addBinary;

/**
 * Given two binary strings, return their sum (also a binary string).
 * @author Mengchao Zhong
 */
public class AddBinary {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addBinary("1", "111"));
	}

	/**
	 * Solution.
	 * @param a
	 * @param b
	 * @return
	 */
    public static String addBinary(String a, String b) {
        int iA = a.length() - 1;
        int iB = b.length() - 1;
        StringBuilder output = new StringBuilder();
        int carry = 0;
        while(iA >= 0 && iB >= 0) {
        	int bit = a.charAt(iA) + b.charAt(iB) + carry - 96;
        	if(bit >= 2) {
        		carry = 1;
        	}
        	else {
        		carry = 0;
        	}
        	output.append(bit % 2);
        	--iA;
        	--iB;
        }
        while(iA >= 0) {
        	int bit = a.charAt(iA) + carry - 48;
        	if(bit >= 2) {
        		carry = 1;
        	}
        	else {
        		carry = 0;
        	}
        	output.append(bit % 2);
        	--iA;
        }
        while(iB >= 0) {
        	int bit = b.charAt(iB) + carry - 48;
        	if(bit >= 2) {
        		carry = 1;
        	}
        	else {
        		carry = 0;
        	}
        	output.append(bit % 2);
        	--iB;
        }
        if(carry == 1) {
        	output.append(carry);
        }
        return output.reverse().toString();
    }
}

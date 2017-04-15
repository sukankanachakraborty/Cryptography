
public class calculateKey {

	static StringBuilder sb = new StringBuilder();

	// Hint given: first letter is 'A'
	// Hence performing the XOR operation between the first character and 'A'
	// gives the first element of the key

	public static String getKey(String binary1) {

		sb = new StringBuilder();

		String key = "";

		String str = "";

		int n = 0;

		int intValue = (int) 'A';

		String binary2 = Integer.toBinaryString(intValue);

		if (binary2.length() < 8) {
			n = 8 - binary2.length();
			str = binary2;
			if (n == 1) {
				binary2 = "0" + str;
			} else if (n == 2) {
				binary2 = "00" + str;
			} else if (n == 3) {
				binary2 = "000" + str;
			} else if (n == 4) {
				binary2 = "0000" + str;
			}
		}

		for (int j = 0; j < binary1.length(); j++) {
			sb.append(calculateChar(calculateBit(binary1.charAt(j)) ^ 
					calculateBit(binary2.charAt(j))));
		}

		key = sb.toString();

		return key;
	}

	// Method to calculate key for other characters

	public static String getKey(String binary1, char c) {

		sb = new StringBuilder();

		String key = "";

		String str = "";

		int n = 0;

		int intValue = (int) c;

		String binary2 = Integer.toBinaryString(intValue);

		if (binary2.length() < 8) {
			n = 8 - binary2.length();
			str = binary2;
			if (n == 1) {
				binary2 = "0" + str;
			} else if (n == 2) {
				binary2 = "00" + str;
			} else if (n == 3) {
				binary2 = "000" + str;
			} else if (n == 4) {
				binary2 = "0000" + str;
			}
		}

		for (int j = 0; j < binary1.length(); j++) {
			sb.append(calculateChar(calculateBit(binary1.charAt(j)) ^ 
					calculateBit(binary2.charAt(j))));
		}

		key = sb.toString();

		return key;

	}

	// Calculating the bit-by-bit value of the XOR operation

	private static boolean calculateBit(char input) {
		boolean result = false;

		if (input == '1') {
			result = true;
		}

		return result;
	}

	private static char calculateChar(boolean input) {
		char result = '\0';

		if (input) {
			result = '1';
		} else {
			result = '0';
		}

		return result;

	}

}

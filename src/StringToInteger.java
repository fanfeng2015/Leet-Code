// LeetCode #8 (String to Integer (atoi)).

// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed
// integer (similar to C/C++'s atoi function).

public class StringToInteger {

	public int myAtoi(String str) {
		int index = 0, result = 0;
		// ignore leading spaces
		while (index < str.length() && str.charAt(index) == ' ') {
			index++;
		}
		if (index == str.length()) {
			return 0;
		}
		// positive or negative?
		int sign = 1;
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index++) == '+' ? 1 : -1;
		}
		for (; index < str.length(); index++) {
			if (!Character.isDigit(str.charAt(index))) {
				break;
			}
			int digit = Character.getNumericValue(str.charAt(index));
			// overflow: 10 * result + digit > Integer.MAX_VALUE ?
			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = 10 * result + digit;
		}
		return result * sign;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

// LeetCode #65 (Valid Number).

// Validate if a given string is numeric.

public class ValidNumber {

	public boolean isNumber(String s) {
		s = s.trim();
		boolean number = false, numberAfterE = true, point = false, e = false;
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				number = true;
				numberAfterE = true;
			} else if (s.charAt(i) == '.') {
				if (e || point) {
					return false;
				}
				point = true;
			} else if (s.charAt(i) == 'e') {
				if (e || !number) {
					return false;
				}
				e = true;
				numberAfterE = false;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				// the previous char must be e
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return number && numberAfterE;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

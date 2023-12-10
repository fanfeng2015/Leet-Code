// LeetCode #65 (Valid Number).

// A valid number can be split up into these components (in order):
// - A decimal number or an integer.
// - (Optional) An 'e' or 'E', followed by an integer.

// A decimal number can be split up into these components (in order):
// - (Optional) A sign character (either '+' or '-').
// - One of the following formats:
//   - One or more digits, followed by a dot '.'.
//   - One or more digits, followed by a dot '.', followed by one or more digits.
//   - A dot '.', followed by one or more digits.

// An integer can be split up into these components (in order):
// - (Optional) A sign character (either '+' or '-').
// - One or more digits.

// For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", 
// "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", 
// "95a54e53"].

// Given a string s, return true if s is a valid number.

public class ValidNumber {

	public boolean isNumber(String s) {
		s = s.trim();
		// indicate existence
		boolean number = false, numberAfterE = true, point = false, e = false;
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				number = true;
				numberAfterE = true;
			} else if (s.charAt(i) == '.') { // . can't be proceeded by e or .
				if (e || point) {
					return false;
				}
				point = true;
			} else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') { // e can't be proceeded by e or non-digit
				if (e || !number) {
					return false;
				}
				e = true;
				numberAfterE = false;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				// either the first char, or the previous char is e
				if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
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

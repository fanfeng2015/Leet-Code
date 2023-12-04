// LeetCode #246 (Strobogrammatic Number).

// Given a string num which represents an integer, return true if num is a strobogrammatic number.

// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

public class StrobogrammaticNumber {

	public boolean isStrobogrammatic(String num) {
		int i = 0, j = num.length() - 1;
		while (i <= j) {
			if (num.charAt(i) == num.charAt(j)) {
				char ch = num.charAt(i);
				if (ch != '0' && ch != '1' && ch != '8') {
					return false;
				}
			} else {
				char left = num.charAt(i), right = num.charAt(j);
				if (!((left == '6' && right == '9') || (left == '9' && right == '6'))) {
					return false;
				}
			}
			i++;
			j--;
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

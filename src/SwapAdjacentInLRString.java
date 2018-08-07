// LeetCode #777 (Swap Adjacent in LR String).

// In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move 
// consists of either replacing one occurrence of "XL" with "LX", or replacing one
// occurrence of "RX" with "XR". 

// Given the starting string start and the ending string end, return True if and only
// if there exists a sequence of moves to transform one string to the other.

public class SwapAdjacentInLRString {

	public boolean canTransform(String start, String end) {
		if (start.length() != end.length()) {
			return false;
		}
		if (!start.replace("X", "").equals(end.replace("X", ""))) {
			return false;
		}
		int p1 = 0, p2 = 0, n = start.length();
		while (p1 < n) {
			while (p1 < n && start.charAt(p1) == 'X') {
				p1++;
			}
			while (p2 < n && end.charAt(p2) == 'X') {
				p2++;
			}
			if (p1 == n || p2 == n) {
				return true;
			}
			if (start.charAt(p1) == 'R' && p1 > p2) {
				return false;
			}
			if (start.charAt(p1) == 'L' && p1 < p2) {
				return false;
			}
			p1++;
			p2++;
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because string is immutable.
}

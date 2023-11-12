// LeetCode #680 (Valid Palindrome II).

// Given a string s, return true if the s can be palindrome after deleting at most one character from it.

public class ValidPalindrome2 {

	public boolean validPalindrome(String s) {
		return validPalindrome(s, 0, s.length() - 1, true);
	}

	private boolean validPalindrome(String s, int left, int right, boolean canDelete) {
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else if (canDelete) {
				return validPalindrome(s, left + 1, right, false) || validPalindrome(s, left, right - 1, false);
			} else {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

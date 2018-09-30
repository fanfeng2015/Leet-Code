// LeetCode #680 (Valid Palindrome II).

// Given a non-empty string s, you may delete at most one character. 

// Judge whether you can make it a palindrome.

// Note: 
// 1. The string will only contain lowercase characters a-z. 
// 2. The maximum length of the string is 50,000.

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

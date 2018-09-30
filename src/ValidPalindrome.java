// LeetCode #125 (Valid Palindrome).

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			} else if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			} else if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

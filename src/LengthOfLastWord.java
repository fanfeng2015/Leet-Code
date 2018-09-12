// LeetCode #58 (Length of Last Word).

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int right = s.length() - 1;
		while (right >= 0 && s.charAt(right) == ' ') {
			right--;
		}
		int left = right;
		while (left >= 0 && s.charAt(left) != ' ') {
			left--;
		}
		return right - left;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

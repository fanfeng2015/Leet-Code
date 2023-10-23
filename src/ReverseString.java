// LeetCode #344 (Reverse String).

// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

public class ReverseString {

	public void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			swap(s, left++, right--);
		}
	}

	private void swap(char[] s, int left, int right) {
		char ch = s[left];
		s[left] = s[right];
		s[right] = ch;
	}

	// Time complexity is O(n)
	// Space complexity is O(1).

	public void reverseString2(char[] s) {
		int left = 0, right = s.length - 1;
		reverseString2(s, left, right);
	}

	private void reverseString2(char[] s, int left, int right) {
		if (left >= right) {
			return;
		}
		swap(s, left, right);
		reverseString2(s, left + 1, right - 1);
	}

	// Time complexity is O(n)
	// Space complexity is O(n).
}

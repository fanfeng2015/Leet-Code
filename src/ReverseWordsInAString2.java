// LeetCode #186 (Reverse Words in a String II).

// Given a character array s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

// Your code must solve the problem in-place, i.e. without allocating extra space.

public class ReverseWordsInAString2 {

	public void reverseWords(char[] s) {
		int start = 0;
		for (int fast = 0; fast < s.length; fast++) {
			if (s[fast] != ' ' && (fast == 0 || s[fast - 1] == ' ')) { // first char
				start = fast;
			}
			if (s[fast] != ' ' && (fast == s.length - 1 || s[fast + 1] == ' ')) { // last char
				reverse(s, start, fast);
			}
		}
		reverse(s, 0, s.length - 1);
	}

	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

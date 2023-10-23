// LeetCode #557 (Reverse Words in a String III).

// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
// and initial word order.

public class ReverseWordsInAString3 {

	public String reverseWords(String s) {
		char[] array = s.toCharArray();
		int start = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' && (fast == 0 || array[fast - 1] == ' ')) { // first char
				start = fast;
			}
			if (array[fast] != ' ' && (fast == array.length - 1 || array[fast + 1] == ' ')) { // last char
				reverse(array, start, fast);
			}
		}
		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n), considering the char array.
}

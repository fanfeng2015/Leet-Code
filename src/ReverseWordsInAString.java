import java.util.Arrays;

// LeetCode #151 (Reverse Words in a String).

// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
// only have a single space separating the words. Do not include any extra spaces.

public class ReverseWordsInAString {

	public String reverseWords(String input) {
		return reverse(removeSpaces(input));
	}

	private String removeSpaces(String input) {
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' || fast > 0 && array[fast - 1] != ' ') {
				array[slow++] = array[fast];
			}
		}
		if (slow > 0 && array[slow - 1] == ' ') {
			slow--;
		}
		return new String(Arrays.copyOf(array, slow));
	}

	public String reverse(String input) {
		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		int start = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' && (fast == 0 || array[fast - 1] == ' ')) {
				start = fast;
			}
			if (array[fast] != ' ' && (fast == array.length - 1 || array[fast + 1] == ' ')) {
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

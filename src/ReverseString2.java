// LeetCode #541 (Reverse String II).

// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
// then reverse the first k characters and leave the other as original.

public class ReverseString2 {

	public String reverseStr(String s, int k) {
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i += 2 * k) {
			swap(array, i, Math.min(i + k - 1, s.length() - 1));
		}
		return new String(array);
	}

	private void swap(char[] array, int left, int right) {
		while (left < right) {
			char ch = array[left];
			array[left++] = array[right];
			array[right--] = ch;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring the char array.

	public String reverseStr2(String s, int k) {
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i += 2 * k) {
			reverseStr2(array, i, Math.min(i + k - 1, array.length - 1));
		}
		return new String(array);
	}

	private void reverseStr2(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

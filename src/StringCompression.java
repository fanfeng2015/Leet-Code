// LeetCode #443 (String Compression). 

// Given an array of characters chars, compress it using the following algorithm:

// Begin with an empty string s. For each group of consecutive repeating characters in chars:
// - If the group's length is 1, append the character to s.
// - Otherwise, append the character followed by the group's length.

// The compressed string s should not be returned separately, but instead, be stored in the input
// character array chars. Note that group lengths that are 10 or longer will be split into multiple
// characters in chars.

// After you are done modifying the input array, return the new length of the array.

// You must write an algorithm that uses only constant extra space.

public class StringCompression {

	public int compress(char[] chars) {
		int result = 0, slow = 0, fast = 0;
		while (fast < chars.length) {
			if (chars[fast] != chars[slow]) {
				result = fillCharsNums(chars, result, slow, fast);
				slow = fast;
			}
			fast++;
		}
		result = fillCharsNums(chars, result, slow, fast);
		return result;
	}

	private int fillCharsNums(char[] chars, int result, int slow, int fast) {
		chars[result++] = chars[slow];
		int count = fast - slow;
		if (count > 1) {
			int numDigits = (int) Math.log10(count) + 1;
			for (int i = numDigits - 1; i >= 0; i--) {
				chars[result++] = (char) (count / Math.pow(10, i) + '0');
				count = count % (int) Math.pow(10, i);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

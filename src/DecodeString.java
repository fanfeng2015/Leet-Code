import java.util.Stack;

// LeetCode #394 (Decode String).

// Given an encoded string, return it's decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square
// brackets is being repeated exactly k times. Note that k is guaranteed to be a positive
// integer.

// You may assume that the input string is always valid. No extra white spaces, square 
// brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any digits and that
// digits are only for those repeat numbers, k. For example, there won't be input like 3a
// or 2[4].

public class DecodeString {

	public String decodeString(String s) {
		String result = "";
		Stack<Integer> counts = new Stack<>();
		Stack<String> sequences = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				int count = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					count = 10 * count + Character.getNumericValue(s.charAt(i++));
				}
				counts.push(count);
			} else if (s.charAt(i) == '[') {
				sequences.add(result);
				result = "";
				i++;
			} else if (s.charAt(i) == ']') {
				StringBuilder temp = new StringBuilder(sequences.pop());
				int count = counts.pop();
				for (int j = 0; j < count; j++) {
					temp.append(result);
				}
				result = temp.toString();
				i++;
			} else {
				result += s.charAt(i++);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

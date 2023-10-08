import java.util.LinkedList;

// LeetCode #394 (Decode String).

// Given an encoded string, return it's decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square
// brackets is being repeated exactly k times. Note that k is guaranteed to be a positive
// integer.

// You may assume that the input string is always valid. No extra white spaces, square 
// brackets are well-formed, etc. Furthermore, you may assume that the original data does 
// not contain any digits and that digits are only for those repeat numbers, k. For example,
// there won't be input like 3a or 2[4].

public class DecodeString {

	public String decodeString(String s) {
		LinkedList<Integer> counts = new LinkedList<>();
		LinkedList<StringBuilder> sbs = new LinkedList<>();
		int k = 0;
		StringBuilder cur = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				k = 10 * k + (s.charAt(i) - '0');
			} else if (s.charAt(i) == '[') { // '[': push to stack
				counts.addLast(k);
				sbs.addLast(cur);
				k = 0;
				cur = new StringBuilder();
			} else if (s.charAt(i) == ']') { // ']': top of stack + count * cur
				Integer count = counts.removeLast();
				StringBuilder sb = sbs.removeLast();
				for (int j = 0; j < count; j++) {
					sb.append(cur);
				}
				cur = sb;
			} else {
				cur.append(s.charAt(i));
			}
		}
		return cur.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

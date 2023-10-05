// LeetCode #1047 (Remove All Adjacent Duplicates In String).

// You are given a string s consisting of lowercase English letters. A duplicate removal 
// consists of choosing two adjacent and equal letters and removing them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It can be 
// proven that the answer is unique.

public class RemoveAllAdjacentDuplicatesInString {

	public String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (sb.length() == 0 || ch != sb.charAt(sb.length() - 1)) {
				sb.append(ch);
			} else {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

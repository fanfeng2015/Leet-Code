import java.util.LinkedList;

// LeetCode #388 (Longest Absolute File Path).

public class LongestAbsoluteFilePath {

	// Assumption: neither directory name, nor file name has \t in it.
	public int lengthLongestPath(String input) {
		LinkedList<Integer> stack = new LinkedList<>(); // stores length
		stack.offerLast(0);
		int result = 0;
		for (String s : input.split("\n")) {
			// \t is treated as a char, or as if it has length 1
			int level = s.lastIndexOf("\t") + 1; // number of tabs
			while (level + 1 < stack.size()) {
				// another directory/file on a previous level
				stack.pollLast();
			}
			int curLength = stack.peekLast() + s.length() - level + 1;
			stack.offerLast(curLength);
			if (s.contains(".")) {
				result = Math.max(result, curLength - 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

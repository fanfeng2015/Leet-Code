import java.util.Arrays;

// LeetCode #833 (Find And Replace in String).

public class FindAndReplaceInString {

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		int[] match = new int[S.length()];
		Arrays.fill(match, -1);
		for (int i = 0; i < indexes.length; i++) {
			int index = indexes[i];
			if (S.substring(index, index + sources[i].length()).equals(sources[i])) {
				match[index] = i;
			}
		}
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		while (cur < S.length()) {
			if (match[cur] >= 0) {
				sb.append(targets[match[cur]]);
				cur += targets[match[cur]].length();
			} else {
				sb.append(S.charAt(cur++));
			}
		}

		return sb.toString();
	}

	// Time complexity is O(n), assuming no overlap between replacements.
	// Space complexity is O(n).
}

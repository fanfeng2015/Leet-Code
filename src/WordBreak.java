import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #139 (Word Break).

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a 
// space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

public class WordBreak {

	// M[i]: Whether [0, i - 1] of input can be composed by concatenating words from
	// the dictionary.
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	// Let s be the length of String s, and n be the size of the dictionary.
	// Time complexity is O(s + n^3).
	// Space complexity is O(s + n).

	// Follow up: Return all possible compositions?
	// LeetCode #140 (Word Break II).
}

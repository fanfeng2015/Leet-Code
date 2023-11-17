import java.util.ArrayList;
import java.util.List;

// LeetCode #17 (Letter Combinations of a Phone Number).

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
// Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class LetterCombinationsOfAPhoneNumber {

	private String[] buttons = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		DFS(digits, sb, result, 0);
		return result;
	}

	private void DFS(String digits, StringBuilder sb, List<String> result, int level) {
		if (level == digits.length()) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < buttons[Character.getNumericValue(digits.charAt(level))].length(); i++) {
			sb.append(buttons[Character.getNumericValue(digits.charAt(level))].charAt(i));
			DFS(digits, sb, result, level + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// Time complexity is O(4^n).
	// Space complexity is O(n).

	// Follow up (Facebook): Given also a dictionary of words, return only
	// combinations that are in the dictionary.
	// Answer: Modify base case of DFS(...).

	// Follow up (Dropbox): Additionally, a combination is valid only if it is
	// comprised of words in the dictionary.
	// Answer: 1. Modify base case of DFS(...) to use LeetCode #139 (Word Break). 2.
	// Construct a Trie tree, and carry a Trie node with DFS(...). If a Trie node is
	// null, continue. Otherwise, add to string builder, DFS, remove from string
	// builder. Add to result only if the last Trie node has isWord equal to true.

	// Follow up: Return a list of list of strings, where each sublist represents
	// words in the dictionary that can compose a valid letter combination.
	// Answer: DFS needs to keep the index of last ending word, and a current
	// running list. In the for loop, add the substring of string builder in [index,
	// sb.length() - 1] to the running list if Trie node has isWord equal to true.
	// Then DFS(...), remove from running list if Trie node has isWord equal to
	// true, remove from sb. Continue...

	// Follow up (Dropbox): You don't have access to the dictionary, but instead you
	// are provided with an API, boolean existInDict(String word) { ... }.
	// Answer: Similar to the above.
}

import java.util.ArrayList;
import java.util.List;

// LeetCode #17 (Letter Combinations of a Phone Number).

// Given a digit string, return all possible letter combinations that the number could represent.

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
	// Answer: Modify base case of DFS(...) to use LeetCode 
	

}

// LeetCode #408 (Valid Word Abbreviation).

// A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not
// have leading zeros.

public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int index = 0, count = 0;
		for (int i = 0; i < abbr.length(); i++) {
			if (Character.isDigit(abbr.charAt(i))) {
				if (count == 0 && Character.getNumericValue(abbr.charAt(i)) == 0) {
					return false;
				}
				count = 10 * count + Character.getNumericValue(abbr.charAt(i));
				continue;
			} else if (count > 0) { // not a digit
				index += count;
				count = 0;
			}
			// count = 0, still need to compare the current char
			if (index >= word.length() || word.charAt(index++) != abbr.charAt(i)) {
				return false;
			}
		}
		return index + count == word.length();
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

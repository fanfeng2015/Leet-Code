// LeetCode #171 (Excel Sheet Column Number).

// Given a column title as appear in an Excel sheet, return its 
// corresponding column number.

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = 26 * result + s.charAt(i) - 'A' + 1;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

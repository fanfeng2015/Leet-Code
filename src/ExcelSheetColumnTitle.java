// LeetCode #168 (Excel Sheet Column Title).

// Given a positive integer, return its corresponding column title as 
// appear in an Excel sheet.

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append((char) ('A' + (n - 1) % 26));
			n = (n - 1) / 26;
		}
		return sb.reverse().toString();
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1), ignoring space needed for output.
}

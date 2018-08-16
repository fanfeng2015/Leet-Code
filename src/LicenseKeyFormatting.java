// LeetCode #482 (License Key Formatting).

// You are given a license key represented as a string S which consists only alphanumeric
// character and dashes. The string is separated into N+1 groups by N dashes.

// Given a number K, we would want to reformat the strings such that each group contains
// exactly K characters, except for the first group which could be shorter than K, but 
// still must contain at least one character. Furthermore, there must be a dash inserted
// between two groups and all lower-case letters should be converted to upper-case.

// Given a non-empty string S and a number K, format the string according to the rules 
// described above.

public class LicenseKeyFormatting {

	public String licenseKeyFormatting(String S, int K) {
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--) {
			char ch = S.charAt(i);
			if (ch != '-') {
				sb.append(ch);
				if (++cur == K) {
					sb.append('-');
					cur = 0;
				}
			}

		}
		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.reverse().toString().toUpperCase();
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring space needed for output.
}

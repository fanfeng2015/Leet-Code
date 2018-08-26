// LeetCode #459 (Repeated Substring Pattern).

// Given a non-empty string check if it can be constructed by taking a substring of it 
// and appending multiple copies of the substring together.

// You may assume the given string consists of lower-case English letters only, and its
// length will not exceed 10,000.

public class RepeatedSubstringPattern {

	// Solution 1
	public boolean repeatedSubstringPattern(String str) {
		int n = str.length();
		for (int i = n / 2; i >= 1; i--) { // length of the substring
			if (n % i == 0) {
				int times = n / i;
				String subString = str.substring(0, i);
				for (int j = 1; j < times; j++) {
					if (!subString.equals(str.substring(i * j, i * (j + 1)))) {
						break;
					}
					if (j == times - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Time complexity is O(sqrt(n) * n).
	// Space complexity is O(1).

	// Solution 2: KMP
	public boolean repeatedSubstringPattern2(String str) {
		int n = str.length();
		int[] kmp = KMP(str);
		return kmp[n - 1] > 0 && n % (n - kmp[n - 1]) == 0;
	}

	private int[] KMP(String str) {
		int i = 1, j = 0, n = str.length();
		int[] kmp = new int[n];
		while (i < n) {
			if (str.charAt(i) == str.charAt(j)) {
				kmp[i++] = ++j;
			} else if (j == 0) {
				i++;
			} else {
				j = kmp[j - 1];
			}
		}
		return kmp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

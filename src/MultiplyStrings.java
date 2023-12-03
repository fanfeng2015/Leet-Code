// LeetCode #43 (Multiply Strings).

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a
// string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] result = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = product + result[p2];
				result[p1] += sum / 10;
				result[p2] = (sum) % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (sb.length() == 0 && result[i] == 0) {
				continue;
			}
			sb.append(result[i]);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m+n).
}

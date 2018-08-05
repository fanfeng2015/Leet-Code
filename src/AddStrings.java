// LeetCode #415 (Add Strings).

// Given two non-negative integers num1 and num2 represented as string, return
// the sum of num1 and num2.

public class AddStrings {

	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1, j = num2.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int sum = carry + (i < 0 ? 0 : Character.getNumericValue(num1.charAt(i--)))
					+ (j < 0 ? 0 : Character.getNumericValue(num2.charAt(j--)));
			sb.append(sum % 10);
			carry = sum / 10;
		}
		sb.append(carry == 0 ? "" : carry);
		return sb.reverse().toString();
	}

	// Time complexity is O(max(m, n)).
	// Space complexity is O(1).
}

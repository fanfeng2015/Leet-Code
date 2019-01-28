// LeetCode #233 (Number of Digit One).

// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

public class NumberOfDigitOne {

	public int countDigitOne(int n) {
		int count = 0;
		for (long k = 1; k <= n; k *= 10) {
			long r = n / k, m = n % k;
			count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
		}
		return count;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

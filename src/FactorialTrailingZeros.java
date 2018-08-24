// LeetCode #172 (Factorial Trailing Zeros).

// Given an integer n, return the number of trailing zeroes in n!.

public class FactorialTrailingZeros {

	public int trailingZeroes(int n) {
		return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).

	public int trailingZeroes2(int n) {
		int count = 0;
		while (n > 0) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

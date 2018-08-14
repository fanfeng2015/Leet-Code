// LeetCode #29 (Divide Two Integer).

// Divide two integers without using multiplication, division and mod operator.

// If it is overflow, return MAX_INT.

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
			return Integer.MAX_VALUE;
		}
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		long x = Math.abs((long) dividend);
		long y = Math.abs((long) divisor);
		int result = 0;
		while (x >= y) {
			long temp = y, quotient = 1;
			while (x >= (temp << 1)) {
				temp <<= 1;
				quotient <<= 1;
			}
			x -= temp;
			result += quotient;
		}
		return negative ? -result : result;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
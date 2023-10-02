// LeetCode #7 (Reverse Integer).

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
// the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

public class ReverseInteger {

	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		int negative = x >= 0 ? 1 : -1;
		x = x >= 0 ? x : -x;
		int result = 0;
		while (x > 0) {
			if (result > (Integer.MAX_VALUE - x % 10) / 10) {
				return 0;
			} else {
				result = 10 * result + x % 10;
			}
			x = x / 10;
		}
		return negative * result;
	}

	// Time complexity is O(log(x)).
	// Space complexity is O(1).
}

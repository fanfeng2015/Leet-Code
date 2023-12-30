// LeetCode #633 (Sum of Square Numbers).

// Given a non-negative integer c, decide whether there're two integers a and b such that a^2 + b^2 = c.

public class SumOfSquareNumbers {

	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a); // sqrt() takes log(n) time
			if (b == (int) b) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(sqrt(c) * log(c)).
	// Space complexity is O(1).

	// Solution 2
	public boolean judgeSquareSum2(int c) {
		for (long a = 0; a * a <= c; a++) {
			int b = c - (int) (a * a);
			if (binarySearch(0, b, b)) {
				return true;
			}
		}
		return false;
	}

	private boolean binarySearch(long left, long right, int target) {
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == target) {
				return true;
			} else if (mid * mid < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	// Time complexity is O(sqrt(c) * log(c)).
	// Space complexity is O(1).
}

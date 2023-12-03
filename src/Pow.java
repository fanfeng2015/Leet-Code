// LeetCode #50 (Pow(x, n)).

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

public class Pow {

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == Integer.MIN_VALUE) {
			return (1 / x) * myPow(x, n + 1);
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).
}

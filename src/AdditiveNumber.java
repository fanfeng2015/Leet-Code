import java.math.BigInteger;

// LeetCode #306 (Additive Number).

// Additive number is a string whose digits can form additive sequence.

// A valid additive sequence should contain at least three numbers. 

// Except for the first two numbers, each subsequent number in the sequence 
// must be the sum of the preceding two.

public class AdditiveNumber {

	public boolean isAdditiveNumber(String num) {
		int n = num.length();
		for (int i = 1; i <= n / 2; i++) {
			// i is the length of the first number
			if (num.charAt(0) == '0' && i > 1) {
				return false;
			}
			BigInteger a = new BigInteger(num.substring(0, i));
			for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
				// j is the length of the second number
				if (num.charAt(i) == '0' && j > 1) {
					break;
				}
				BigInteger b = new BigInteger(num.substring(i, i + j));
				if (isAdditiveNumber(a, b, num, i + j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAdditiveNumber(BigInteger a, BigInteger b, String num, int start) {
		if (start == num.length()) {
			return true;
		}
		String sum = a.add(b).toString();
		a = b;
		b = new BigInteger(sum);
		return num.startsWith(sum, start) && isAdditiveNumber(a, b, num, start + sum.length());
	}

}
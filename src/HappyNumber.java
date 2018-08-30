import java.util.HashSet;
import java.util.Set;

// LeetCode #202 (Happy Number).

// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares 
// of its digits, and repeat the process until the number equals 1 (where it will 
// stay), or it loops endlessly in a cycle which does not include 1.

// Those numbers for which this process ends in 1 are happy numbers.

public class HappyNumber {

	// Solution 1
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int cur = n, next = 0;
		while (cur > 1) {
			while (cur > 0) {
				next += Math.pow(cur % 10, 2);
				cur /= 10;
			}
			if (!set.add(next)) {
				return false;
			}
			cur = next;
			next = 0;
		}
		return true;
	}

	// Solution 2: Floyd cycle detection
	public boolean isHappy2(int n) {
		int slow = n, fast = n;
		do {
			slow = sumOfSquares(slow);
			fast = sumOfSquares(fast);
			fast = sumOfSquares(fast);
		} while (slow != fast);
		return slow == 1;
	}

	private int sumOfSquares(int n) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		return sum;
	}

}
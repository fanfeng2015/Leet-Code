// LeetCode #9 (Palindrome Number).

// Given an integer x, return true if x is a palindrome, and false otherwise.

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int reverse = 0;
		while (x > reverse) { // optimization
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return (x == reverse || x == reverse / 10);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).	
}

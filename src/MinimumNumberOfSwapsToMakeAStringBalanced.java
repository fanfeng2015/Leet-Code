// LeetCode #1963 (Minimum Number of Swaps to Make the String Balanced).

// You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets
// '[' and n / 2 closing brackets ']'.

// You may swap the brackets at any two indices any number of times.

// Return the minimum number of swaps to make s balanced.

public class MinimumNumberOfSwapsToMakeAStringBalanced {

	// after balanced parentheses are canceled out, the remaining string is in the
	// form of "]]][[["
	// then it's just an observation that count = (n + 1) / 2, proof?
	public int minSwaps(String s) {
		int balance = 0;
		for (char ch : s.toCharArray()) {
			balance = (ch == '[') ? balance + 1 : balance;
			balance = (ch == ']' && balance > 0) ? balance - 1 : balance;
		}
		return (balance + 1) / 2;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

// ][, 1
// ]][[, 1
// ]]][[[, []]][[, [[]][], 2
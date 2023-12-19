// LeetCode #1541 (Minimum Insertions to Balance a Parentheses String).

// Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
// - Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
// - Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.

// In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
// - For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

// You can insert the characters '(' and ')' at any position of the string to balance it if needed.

// Return the minimum number of insertions needed to make s balanced.

public class MinimumInsertionsToBalanceAParenthesesString {

	public int minInsertions(String s) {
		int balance = 0, result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // else { } guarantees that balance is >= 0
				if (balance % 2 == 1) {
					balance--;
					result++;
				}
				balance += 2;
			} else { // ')'
				balance--;
				if (balance < 0) { // need to add at least one '('
					balance += 2;
					result++;
				}
			}
		}
		return result + balance;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).	
}

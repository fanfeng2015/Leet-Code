import java.util.Deque;
import java.util.LinkedList;

// LeetCode #921 (Minimum Add to Make Parentheses Valid).

// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the
// string.

// Return the minimum number of moves required to make s valid.

public class MinimumAddToMakeAParenthesesValid {

	public int minAddToMakeValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (ch == ')' && !stack.isEmpty() && stack.peekFirst() == '(') {
				stack.pollFirst();
			} else {
				stack.offerFirst(ch);
			}
		}
		return stack.size();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public int minAddToMakeValid2(String s) {
		int balance = 0, count = 0;
		for (char ch : s.toCharArray()) {
			balance += (ch == '(' ? 1 : -1);
			if (balance < 0) { // need to add a left parentheses
				count++;
				balance++;
			}
		}
		return count + balance;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

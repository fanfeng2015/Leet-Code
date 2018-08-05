import java.util.ArrayList;
import java.util.List;

// LeetCode #682 (Baseball Game).

// You're now a baseball game point recorder.

// Given a list of strings, each string can be one of the 4 following types:

// Integer (one round's score): Directly represents the number of points you get in this round.
// "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
// "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
// "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
// Each round's operation is permanent and could have an impact on the round before and the round after.

// You need to return the sum of the points you could get in all the rounds.

public class BaseballGame {

	public int calPoints(String[] ops) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < ops.length; i++) {
			if (ops[i].equals("+")) { // assume always valid
				int cur = list.get(list.size() - 1) + list.get(list.size() - 2);
				sum += cur;
				list.add(cur);
			} else if (ops[i].equals("C")) {
				int last = list.remove(list.size() - 1);
				sum -= last;
			} else if (ops[i].equals("D")) {
				int last = list.get(list.size() - 1);
				list.add(2 * last);
				sum += 2 * last;
			} else { // assume always valid
				int cur = Integer.parseInt(ops[i]);
				list.add(cur);
				sum += cur;
			}
		}
		return sum;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
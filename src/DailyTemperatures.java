import java.util.LinkedList;

// LeetCode #739 (Daily Temperatures).

// Given a list of daily temperatures, produce a list that, for each day in the input, 
// tells you how many days you would have to wait until a warmer temperature. If there
// is no future day for which this is possible, put 0 instead.

// For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your 
// output should be [1, 1, 4, 2, 1, 1, 0, 0].

// Note: The length of temperatures will be in the range [1, 30000]. Each temperature 
// will be an integer in the range [30, 100].

public class DailyTemperatures {

	// monotonic stack
	public int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		LinkedList<Integer> stack = new LinkedList<>(); // store index
		for (int i = 0; i < temperatures.length; i++) {
			while (stack.peekLast() != null && temperatures[i] > temperatures[stack.peekLast()]) {
				result[stack.peekLast()] = i - stack.peekLast();
				stack.pollLast();
			}
			stack.offerLast(i);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

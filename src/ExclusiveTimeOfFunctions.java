import java.util.List;
import java.util.Stack;

// LeetCode #636 (Exclusive Time of Functions).

// Given the running logs of n functions that are executed in a non-preemptive single
// threaded CPU, find the exclusive time of these functions.

// Each function has a unique id, start from 0 to n-1. A function may be called recursively
// or by another function.

// A log is a string has this format : function_id:start_or_end:timestamp. For example, 
// "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means 
// function 0 ends at the very end of time 0.

// Exclusive time of a function is defined as the time spent within this function, the time
// spent by calling other functions should not be considered as this function's exclusive 
// time. You should return the exclusive time of each function sorted by their function id.

public class ExclusiveTimeOfFunctions {

	public int[] exclusiveTime(int n, List<String> logs) {
		int prev = 0;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>(); // functions
		for (String log : logs) {
			String[] instructions = log.split(":");
			int function = Integer.valueOf(instructions[0]);
			int cur = Integer.valueOf(instructions[2]);
			if (!stack.isEmpty()) {
				result[stack.peek()] += cur - prev;
				prev = cur;
			}
			if (instructions[1].equals("start")) {
				stack.push(function);
			} else { // Note: end at the very end of time
				prev++;
				result[function]++;
				stack.pop();
			}
		}
		return result;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(n).
}

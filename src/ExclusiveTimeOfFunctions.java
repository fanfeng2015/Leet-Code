import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// LeetCode #636 (Exclusive Time of Functions).

// On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.

// Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call
// ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. 
// Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

// You are given a list logs, where logs[i] represents the ith log message formatted as a string 
// "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the 
// beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a 
// function can be called multiple times, possibly recursively.

// A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is 
// called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

// Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the 
// function with ID i.

public class ExclusiveTimeOfFunctions {

	// ------------------------------ 2023 ------------------------------
	private class Log {
		private int id;
		private boolean start;
		private int time;

		Log(String str) {
			String[] array = str.split(":");
			this.id = Integer.valueOf(array[0]);
			this.start = array[1].equals("start");
			this.time = Integer.valueOf(array[2]);
		}
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		LinkedList<Log> stack = new LinkedList<>();
		for (int i = 0; i < logs.size(); i++) {
			String str = logs.get(i);
			Log cur = new Log(str);
			if (cur.start) {
				stack.offerLast(cur);
			} else {
				// there must be a prev log of the same id, and is a start
				Log prev = stack.pollLast();
				result[cur.id] += cur.time - prev.time + 1;
				if (!stack.isEmpty()) {
					Log top = stack.peekLast();
					result[top.id] -= cur.time - prev.time + 1;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n), string operations take O(1) time since the format is
	// fixed.
	// Space complexity is O(n).

	// ------------------------------ 2018 ------------------------------
	public int[] exclusiveTime2(int n, List<String> logs) {
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

	// Time complexity is O(n), string operations take O(1) time since the format is
	// fixed.
	// Space complexity is O(n).
}

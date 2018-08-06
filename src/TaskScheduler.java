import java.util.Arrays;

// LeetCode #621 (Task Scheduler).

// Given a char array representing tasks CPU need to do. It contains capital letters A to Z 
// where different letters represent different tasks. Tasks could be done without original order. 
// Each task could be done in one interval. For each interval, CPU could finish one task or just
// be idle.

// However, there is a non-negative cooling interval n that means between two same tasks, 
// there must be at least n intervals that CPU are doing different tasks or just be idle.

// You need to return the least number of intervals the CPU will take to finish all the given 
// tasks.

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for (char c : tasks) {
			count[c - 'A']++;
		}
		Arrays.sort(count);
		int index = 25;
		while (index >= 0 && count[index] == count[25]) {
			index--;
		}
		return Math.max(tasks.length, (count[25] - 1) * (n + 1) + (25 - index));
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

import java.util.HashMap;
import java.util.Map;

// LeetCode #2365 (Task Scheduler II).

// You are given a 0-indexed array of positive integers tasks, representing tasks that need to be completed in order, where
// tasks[i] represents the type of the ith task.

// You are also given a positive integer space, which represents the minimum number of days that must pass after the 
// completion of a task before another task of the same type can be performed.

// Each day, until all tasks have been completed, you must either:

// - Complete the next task from tasks, or
// - Take a break.

// Return the minimum number of days needed to complete all tasks.

public class TaskScheduler2 {

	public long taskSchedulerII(int[] tasks, int space) {
		long cur = 0;
		Map<Integer, Long> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			if (map.containsKey(tasks[i]) && map.get(tasks[i]) >= cur - space) { // 0 >= 2 - 3, cur should become 4
				cur = map.get(tasks[i]) + space + 1;
			}
			map.put(tasks[i], cur++);
		}
		return cur;
	}

	// Time complexity is O(t).
	// Space complexity is O(t).
}

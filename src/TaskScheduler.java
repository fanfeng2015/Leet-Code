import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// LeetCode #621 (Task Scheduler).

// Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
// Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete 
// either one task or just be idle.

// However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter 
// in the array), that is that there must be at least n units of time between any two same tasks.

// Return the least number of units of times that the CPU will take to finish all the given tasks.

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

	// Time complexity is O(t).
	// Space complexity is O(1).

	// Similar to LeetCode #767 (Reorganize String) and #358 (Rearrange String k
	// Distance Apart).
	public int leastInterval2(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char task : tasks) {
			Integer count = map.get(task);
			count = (count == null) ? 1 : (count + 1);
			map.put(task, count);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> (b.getValue() - a.getValue())); // entry with larger value has higher priority
		maxHeap.addAll(map.entrySet());

		int result = 0;
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		while (!maxHeap.isEmpty()) {
			int cur = n; // current round
			while (cur >= 0 && !maxHeap.isEmpty()) {
				cur--;
				result++;
				Map.Entry<Character, Integer> entry = maxHeap.poll();
				entry.setValue(entry.getValue() - 1);
				queue.offer(entry);
			}
			while (!queue.isEmpty()) {
				Map.Entry<Character, Integer> entry = queue.poll();
				if (entry.getValue() > 0) {
					maxHeap.offer(entry);
				}
			}
			// need (cur + 1) idle times as long as this is not the last round
			if (!maxHeap.isEmpty()) {
				result = result + cur + 1;
			}
		}
		return result;
	}

	// Time complexity is O(t*log(t)).
	// Space complexity is (t).
}

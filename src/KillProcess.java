import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// LeetCode #582 (Kill Process).

// Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

// Each process only has one parent process, but may have one or more children processes. This is 
// just like a tree structure. Only one process has PPID that is 0, which means this process has no
// parent process. All the PIDs will be distinct positive integers.

// We use two list of integers to represent a list of processes, where the first list contains PID
// for each process and the second list contains the corresponding PPID.

// Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs
// of processes that will be killed in the end. You should assume that when a process is killed, all
// its children processes will be killed. No order is required for the final answer.

public class KillProcess {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		int n = pid.size();
		Map<Integer, List<Integer>> tree = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!tree.containsKey(ppid.get(i))) {
				tree.put(ppid.get(i), new ArrayList<>());
			}
			tree.get(ppid.get(i)).add(pid.get(i));

		}
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(kill);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			if (tree.containsKey(cur)) {
				queue.addAll(tree.get(cur));
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

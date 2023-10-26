import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #207 (Course Schedule).

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
// prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course
// ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

// Return true if you can finish all courses. Otherwise, return false.

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] incomingDegrees = new int[numCourses];
		// adjacentList.get(i) contains all of the next nodes from i
		List<List<Integer>> adjacentList = new ArrayList<>();
		constructGraph(prerequisites, incomingDegrees, adjacentList);
		return topologicalOrder(incomingDegrees, adjacentList) == numCourses;
	}

	private void constructGraph(int[][] prerequisites, int[] incomingDegrees, List<List<Integer>> adjacentList) {
		int numCourses = incomingDegrees.length;
		for (int i = 0; i < numCourses; i++) {
			adjacentList.add(new ArrayList<Integer>());
		}
		for (int[] prereq : prerequisites) {
			incomingDegrees[prereq[0]]++;
			adjacentList.get(prereq[1]).add(prereq[0]);
		}
	}

	private int topologicalOrder(int[] incomingDegrees, List<List<Integer>> adjacentList) {
		int numCourses = incomingDegrees.length;
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (incomingDegrees[i] == 0) {
				queue.offerFirst(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int cur = queue.pollLast();
			for (int neighbor : adjacentList.get(cur)) {
				incomingDegrees[neighbor]--;
				if (incomingDegrees[neighbor] == 0) {
					queue.offerFirst(neighbor);
				}
			}
		}
		return count;
	}

	// Time complexity is O(n), where n is the number of prerequisites.
	// Space complexity is O(n).
}

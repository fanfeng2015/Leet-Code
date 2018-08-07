import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #207 (Course Schedule).

// There are a total of n courses you have to take, labeled from 0 to n-1.

// Some courses may have prerequisites, for example to take course 0 you have
// to first take course 1, which is expressed as a pair [0, 1].

// Given the total number of courses and a list of prerequisite pairs, is it
// possible for you to finish all courses? 

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] incomingDegrees = new int[numCourses];
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

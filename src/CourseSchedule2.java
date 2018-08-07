import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #210 (Course Schedule II).

// There are a total of n courses you have to take, labeled from 0 to n-1.

// Some courses may have prerequisites, for example to take course 0 you have
// to first take course 1, which is expressed as a pair [0, 1].

// Given the total number of courses and a list of prerequisite pairs, return 
// the ordering of courses you should take to finish all courses.

// There may be multiple correct orders, you just need to return one of them.
// If it is impossible to finish all courses,return an empty array.

public class CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incomingDegrees = new int[numCourses];
		List<List<Integer>> adjacentList = new ArrayList<>();
		constructGraph(prerequisites, incomingDegrees, adjacentList);
		return topologicalOrder(incomingDegrees, adjacentList);
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

	private int[] topologicalOrder(int[] incomingDegrees, List<List<Integer>> adjacentList) {
		int numCourses = incomingDegrees.length;
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (incomingDegrees[i] == 0) {
				queue.offerFirst(i);
			}
		}
		int index = 0;
		int[] result = new int[numCourses];
		while (!queue.isEmpty()) {
			int cur = queue.pollLast();
			result[index++] = cur;
			for (int neighbor : adjacentList.get(cur)) {
				incomingDegrees[neighbor]--;
				if (incomingDegrees[neighbor] == 0) {
					queue.offerFirst(neighbor);
				}
			}
		}
		return (index == numCourses) ? result : new int[] {};
	}

	// Time complexity is O(n), where n is the number of prerequisites.
	// Space complexity is O(n).
}

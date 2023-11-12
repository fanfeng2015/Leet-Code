import java.util.LinkedList;
import java.util.List;

// LeetCode #339 (Nested List Weight Sum).

// Given a nested list of integers, return the sum of all integers in the list weighted by
// their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or 
// other lists.

public class NestedListWeightSum {

	// DFS
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += depthSum(ni.getList(), depth + 1);
			}
		}
		return sum;
	}

	// Time complexity is O(n), where n is the number of nested integers.
	// Space complexity is O(d), where d is the largest depth.

	// BFS
	public int depthSum2(List<NestedInteger> nestedList) {
		int sum = 0, depth = 1;
		LinkedList<NestedInteger> queue = new LinkedList<>(nestedList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.removeFirst();
				if (ni.isInteger()) {
					sum += ni.getInteger() * depth;
				} else {
					queue.addAll(ni.getList());
				}
			}
			depth++;
		}
		return sum;
	}

	// Time complexity is O(n), where n is the total number of nested integers.
	// Space complexity is O(n).
}

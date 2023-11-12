import java.util.LinkedList;
import java.util.List;

// LeetCode #339 (Nested List Weight Sum).

// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be
// integers or other lists.

// The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each
// integer's value set to its depth.

// Return the sum of each integer in nestedList multiplied by its depth.

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

	// Time complexity is O(n), where n is the number of nested integers.
	// Space complexity is O(n).
}

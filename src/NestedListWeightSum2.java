import java.util.LinkedList;
import java.util.List;

// LeetCode #364 (Nested List Weight Sum II).

// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be
// integers or other lists.

// The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each
// integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

// The weight of an integer is maxDepth - (the depth of the integer) + 1.

// Return the sum of each integer in nestedList multiplied by its weight.

public class NestedListWeightSum2 {

	// Solution 1: Get depth, then sum in reverse order.
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int depth = findDepth(nestedList, 1, 1);
		return depthSumInverse(nestedList, depth);
	}

	public int findDepth(List<NestedInteger> nestedList, int max, int depth) {
		for (NestedInteger ni : nestedList) {
			max = Math.max(max, depth);
			if (!ni.isInteger()) {
				max = Math.max(max, findDepth(ni.getList(), max, depth + 1));
			}
		}
		return max;
	}

	public int depthSumInverse(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += depthSumInverse(ni.getList(), depth - 1);
			}
		}
		return sum;
	}

	// Time complexity is O(n), where n is the number of nested integers.
	// Space complexity is O(d), where d is the largest depth.

	// Solution 2: BFS
	public int depthSumInverse2(List<NestedInteger> nestedList) {
		int sum = 0, cur = 0;
		LinkedList<NestedInteger> queue = new LinkedList<>(nestedList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.removeFirst();
				if (ni.isInteger()) {
					cur += ni.getInteger();
				} else {
					queue.addAll(ni.getList());
				}
			}
			sum += cur;
		}
		return sum;
	}

	// Time complexity is O(n), where n is the number of nested integers.
	// Space complexity is O(n).
}

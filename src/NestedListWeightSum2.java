import java.util.LinkedList;
import java.util.List;

// LeetCode #364 (Nested List Weight Sum II).

// Given a nested list of integers, return the sum of all integers in the list weighted by
// their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or 
// other lists.

// Different from the previous question where weight is increasing from root to leaf, now
// the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and
// the root level integers have the largest weight.

public class NestedListWeightSum2 {

	// Solution 1: Get depth, then sum in reverse order.
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int depth = findDepth(nestedList, new Integer[] { 1 }, new Integer[] { 1 });
		return depthSumInverse(nestedList, new Integer[] { 0 }, new Integer[] { depth });
	}

	public int findDepth(List<NestedInteger> nestedList, Integer[] max, Integer[] depth) {
		for (NestedInteger ni : nestedList) {
			max[0] = Math.max(max[0], depth[0]);
			if (!ni.isInteger()) {
				findDepth(ni.getList(), max, new Integer[] { depth[0] + 1 });
			}
		}
		return max[0];
	}

	public int depthSumInverse(List<NestedInteger> nestedList, Integer[] sum, Integer[] depth) {
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum[0] += depth[0] * ni.getInteger();
			} else {
				depthSumInverse(ni.getList(), sum, new Integer[] { depth[0] - 1 });
			}
		}
		return sum[0];
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack.

	// Solution 2: BFS
	public int depthSumInverse2(List<NestedInteger> nestedList) {
		int result = 0, cur = 0;
		LinkedList<NestedInteger> queue = new LinkedList<>();
		for (NestedInteger ni : nestedList) {
			queue.offerFirst(ni);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.pollLast();
				if (ni.isInteger()) {
					cur += ni.getInteger();
				} else if (ni.getList() != null) {
					for (NestedInteger element : ni.getList()) {
						queue.offerFirst(element);
					}
				}
			}
			result += cur;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

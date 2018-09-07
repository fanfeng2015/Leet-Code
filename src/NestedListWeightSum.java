import java.util.List;

// LeetCode #339 (Nested List Weight Sum).

// Given a nested list of integers, return the sum of all integers in the list weighted by
// their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or 
// other lists.

public class NestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, new Integer[] { 0 }, new Integer[] { 1 });
	}

	public int depthSum(List<NestedInteger> nestedList, Integer[] sum, Integer[] depth) {
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum[0] += depth[0] * ni.getInteger();
			} else {
				depthSum(ni.getList(), sum, new Integer[] { depth[0] + 1 });
			}
		}
		return sum[0];
	}

	// Time complexity is O(n), where n is the total number of integers.
	// Space complexity is O(n), because of call-stack.
}

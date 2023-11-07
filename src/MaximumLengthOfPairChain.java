import java.util.Arrays;

// LeetCode #646 (Maximum Length of Pair Chain).

// You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

// Return the length longest chain which can be formed.

// You do not need to use up all the given intervals. You can select pairs in any order.

public class MaximumLengthOfPairChain {

	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0])); // sort by start
		int length = 0, end = pairs[0][1];
		for (int i = 1; i < pairs.length; i++) {
			if (end < pairs[i][0]) {
				length++;
				end = pairs[i][1];
			} else {
				end = Math.min(end, pairs[i][1]);
			}
		}
		return length + 1;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)), because of merge sort for non-primitive types.
}

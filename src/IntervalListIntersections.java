import java.util.ArrayList;
import java.util.List;

// LeetCode #986 (Interval List Intersections).

// You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and 
// secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

// Return the intersection of these two interval lists.

// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

// The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. 
// For example, the intersection of [1, 3] and [2, 4] is [2, 3].

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] first, int[][] second) {
		int i = 0, j = 0;
		List<int[]> intervals = new ArrayList<>();
		while (i < first.length && j < second.length) {
			int lo = Math.max(first[i][0], second[j][0]);
			int hi = Math.min(first[i][1], second[j][1]);
			if (lo <= hi) {
				intervals.add(new int[] { lo, hi });
			}
			if (first[i][1] < second[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		int[][] result = new int[intervals.size()][2];
		for (int index = 0; index < intervals.size(); index++) {
			result[index] = intervals.get(index);
		}
		return result;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(min(m, n)).
}

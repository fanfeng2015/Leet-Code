import java.util.Arrays;

// LeetCode #435 (Non-overlapping Intervals).

// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make
// the rest of the intervals non-overlapping.

public class NonOverlappingIntervals {

	// 1. Sort the intervals by start time.
	// 2. When overlapping, count + 1, and keep the interval with smaller end time.
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
		int end = intervals[0][1], count = 0; // don't need start
		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];
			if (end <= next[0]) { // non-overlapping
				end = next[1];
			} else {
				count++;
				end = Math.min(end, next[1]); // keep the interval with smaller end time
			}
		}
		return count;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}

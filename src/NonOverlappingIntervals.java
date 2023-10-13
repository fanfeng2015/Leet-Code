import java.util.Arrays;

// LeetCode #435 (Non-overlapping Intervals).

// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number
// of 0 and 1.

public class NonOverlappingIntervals {

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
		int start = intervals[0][0], end = intervals[0][1], count = 0;
		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];
			if (end <= next[0]) {
				start = next[0];
				end = next[1];
			} else {
				count++;
				start = (end <= next[1]) ? start : next[0]; // keep the interval with shorter end time
				end = (end <= next[1]) ? end : next[1];
			}
		}
		return count;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}

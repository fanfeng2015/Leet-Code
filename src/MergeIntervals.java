import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// LeetCode #56 (Merge Intervals).

// Given a collection of intervals, merge all overlapping intervals.

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, (a, b) -> (a.start - b.start));
		for (Interval interval : intervals) {
			Interval lastInterval = result.size() > 0 ? result.get(result.size() - 1) : null;
			if (lastInterval == null || lastInterval.end < interval.start) {
				result.add(interval);
			} else {
				lastInterval.end = Math.max(lastInterval.end, interval.end);
			}
		}
		return result;
	}

	public int[][] merge(int[][] intervals) {
		LinkedList<int[]> result = new LinkedList<>();
		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
		for (int[] interval : intervals) {
			if (result.isEmpty() || result.getLast()[1] < interval[0]) {
				result.addLast(interval);
			} else {
				result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}

import java.util.ArrayList;
import java.util.List;

// LeetCode #57 (Insert Interval).

// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the 
// ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents
// the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any 
// overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

public class InsertInterval {

	// ------------------------------ 2018 ------------------------------
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i++));
		}
		int lo = newInterval.start, hi = newInterval.end;
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			lo = Math.min(lo, intervals.get(i).start);
			hi = Math.max(hi, intervals.get(i).end);
			i++;
		}
		result.add(new Interval(lo, hi));
		while (i < intervals.size()) {
			result.add(intervals.get(i++));
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// ------------------------------ 2023 ------------------------------
	public int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> result = new ArrayList<>();
		int index = 0;
		while (index < intervals.length && intervals[index][1] < newInterval[0]) {
			result.add(intervals[index++]);
		}
		int start = newInterval[0], end = newInterval[1];
		while (index < intervals.length && intervals[index][0] <= end) {
			start = Math.min(start, intervals[index][0]);
			end = Math.max(end, intervals[index][1]);
			index++;
		}
		result.add(new int[] { start, end });
		while (index < intervals.length) {
			result.add(intervals[index++]);
		}
		return result.toArray(new int[result.size()][]);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but that's because of the input/return type.
}

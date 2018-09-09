import java.util.ArrayList;
import java.util.List;

// LeetCode #57 (Insert Interval).

// Given a set of non-overlapping intervals, insert a new interval into the intervals 
// (merge if necessary).

// You may assume that the intervals were initially sorted according to their start 
// times.

public class InsertInterval {

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
}

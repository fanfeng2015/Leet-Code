import java.util.ArrayList;
import java.util.Collections;
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

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}

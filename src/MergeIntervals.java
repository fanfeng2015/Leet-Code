import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// LeetCode #56 (Merge Intervals).

// Given a collection of intervals, merge all overlapping intervals.

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new IntervalComparator());
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

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return 0;
			}
			return i1.start < i2.start ? -1 : 1;
		}
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// LeetCode #731 (My Calendar II).

// Implement a MyCalendar2 class to store your events. A new event can be added if adding the event will not
// cause a triple booking.

// Your class will have one method, book(int start, int end). Formally, this represents a booking on the half
// open interval [start, end), the range of real numbers x such that start <= x < end.

// A triple booking happens when three events have some non-empty intersection (ie., there is some time that 
// is common to all 3 events.)

// For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
// without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

public class MyCalendar2 {

	public MyCalendar2() {

	}

	private static class Interval {
		private int start;
		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	// Solution 1: Brute force
	List<Interval> intervals = new ArrayList<>();
	List<Interval> overlaps = new ArrayList<>();

	public boolean book(int start, int end) {
		for (Interval overlap : overlaps) {
			if (start < overlap.end && end > overlap.start) {
				return false;
			}
		}
		for (Interval interval : intervals) {
			if (start < interval.end && end > interval.start) {
				overlaps.add(new Interval(Math.max(start, interval.start), Math.min(end, interval.end)));
			}
		}
		intervals.add((new Interval(start, end)));
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: Red-black tree (TreeMap in Java).
	// { t: count of intervals that start from t (+1) or end at t (-1) }
	TreeMap<Integer, Integer> calendar = new TreeMap<>();

	public boolean book2(int start, int end) {
		calendar.put(start, calendar.getOrDefault(start, 0) + 1);
		calendar.put(end, calendar.getOrDefault(end, 0) - 1);
		int overlap = 0;
		for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) { // in ascending key order
			overlap += entry.getValue();
			if (overlap == 3) { // number of start - number of end = 3
				calendar.put(start, calendar.get(start) - 1);
				calendar.put(end, calendar.get(end) + 1);
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

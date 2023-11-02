import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// LeetCode #731 (My Calendar II).

// You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple 
// booking.

// A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three 
// events.).

// The event can be represented as a pair of integers start and end that represents a booking on the half-open interval 
// [start, end), the range of real numbers x such that start <= x < end.

// Implement the MyCalendarTwo class:

// - MyCalendarTwo() Initializes the calendar object.
// - boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a 
//   triple booking. Otherwise, return false and do not add the event to the calendar.

public class MyCalendar2 {

	public MyCalendar2() {
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

	private static class Interval {
		private int start;
		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	// Solution 2: Red-black tree (TreeMap in Java).
	// { t: count of intervals that start from t (+1) or end at t (-1) }
	TreeMap<Integer, Integer> calendar = new TreeMap<>();

	public boolean book2(int start, int end) {
		calendar.put(start, calendar.getOrDefault(start, 0) + 1);
		calendar.put(end, calendar.getOrDefault(end, 0) - 1);
		int overlap = 0;
		for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) { // in ascending key order
			overlap += entry.getValue();
			if (overlap == 3) { // can't book, need to remove
				calendar.put(start, calendar.get(start) - 1);
				calendar.put(end, calendar.get(end) + 1);
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n)
	// Note that put() method takes O(log) time, but is only one operation.
	// Space complexity is O(n).
}

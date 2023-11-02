import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// LeetCode #729 (My Calendar I).

// You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double
// booking.

// A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

// The event can be represented as a pair of integers start and end that represents a booking on the half-open interval 
// [start, end), the range of real numbers x such that start <= x < end.

// Implement the MyCalendar class:

// - MyCalendar() Initializes the calendar object.
// - boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a 
//   double booking. Otherwise, return false and do not add the event to the calendar.

public class MyCalendar {

	public MyCalendar() {
	}

	// Solution 1: Brute force
	List<Interval> intervals = new ArrayList<>();

	public boolean book(int start, int end) {
		for (Interval interval : intervals) {
			if (start < interval.end && end > interval.start) {
				return false;
			}
		}
		intervals.add(new Interval(start, end));
		return true;
	}

	// Time complexity is O(n)
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
	TreeMap<Integer, Integer> calendar = new TreeMap<>();

	public boolean book2(int start, int end) {
		Integer floorKey = calendar.floorKey(start); // the greatest key <= start
		if (floorKey != null && start < calendar.get(floorKey)) {
			return false;
		}
		Integer ceilingKey = calendar.ceilingKey(start); // the least key >= start
		if (ceilingKey != null && end > ceilingKey) {
			return false;
		}
		calendar.put(start, end);
		return true;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(n).
}

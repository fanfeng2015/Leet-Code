import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// LeetCode #729 (My Calendar I).

// Implement a MyCalendar class to store your events. A new event can be added if adding the event
// will not cause a double booking.

// Your class will have the method, book(int start, int end). Formally, this represents a booking on
// the half open interval [start, end), the range of real numbers x such that start <= x < end.

// A double booking happens when two events have some non-empty intersection (i.e., there is some time
// that is common to both events.)

// For each call to the method MyCalendar.book, return true if the event can be added to the calendar 
// successfully without causing a double booking. Otherwise, return false and do not add the event to 
// the calendar.

public class MyCalendar {

	public MyCalendar() {

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

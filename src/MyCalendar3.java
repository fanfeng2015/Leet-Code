import java.util.Map;
import java.util.TreeMap;

// LeetCode #732 (My Calendar III).

// A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

// You are given some events [startTime, endTime), after each given event, return an integer k representing the maximum k-booking 
// between all the previous events.

// Implement the MyCalendarThree class:

// - MyCalendarThree() Initializes the object.
// - int book(int startTime, int endTime) Returns an integer k representing the largest integer such that there exists a k-booking
//   in the calendar.

public class MyCalendar3 {

	public MyCalendar3() {

	}

	// { t: count of intervals that start from t (+1) or end at t (-1) }
	TreeMap<Integer, Integer> calendar = new TreeMap<>();

	public int book(int start, int end) {
		calendar.put(start, calendar.getOrDefault(start, 0) + 1);
		calendar.put(end, calendar.getOrDefault(end, 0) - 1);
		int cur = 0, count = 0;
		for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
			cur += entry.getValue();
			count = Math.max(count, cur);
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

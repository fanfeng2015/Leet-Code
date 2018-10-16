import java.util.Map;
import java.util.TreeMap;

// LeetCode #732 (My Calendar III).

// Implement a MyCalendarThree class to store your events. A new event can always be added.

// Your class will have one method, book(int start, int end). Formally, this represents a booking
// on the half open interval [start, end), the range of real numbers x such that start <= x < end.

// A K-booking happens when K events have some non-empty intersection (ie., there is some time that
// is common to all K events.)

// For each call to the method MyCalendar.book, return an integer K representing the largest integer
// such that there exists a K-booking in the calendar.

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

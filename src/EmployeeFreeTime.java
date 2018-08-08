import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LeetCode #759 (Employee Free Time).

// We are given a list schedule of employees, which represents the working time 
// for each employee.

// Each employee has a list of non-overlapping Intervals, and these intervals are
// in sorted order.

// Return the list of finite intervals representing common, positive-length free 
// time for all employees, also in sorted order.

public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<int[]> events = new ArrayList<>(); // [ time, 0/1 ]
		for (List<Interval> employee : schedule) {
			for (Interval interval : employee) {
				events.add(new int[] { interval.start, 0 });
				events.add(new int[] { interval.end, 1 });
			}
		}
		// sort first by time, then by start/end
		Collections.sort(events, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
		int count = 0, prev = -1;
		List<Interval> result = new ArrayList<>();
		for (int[] event : events) {
			if (count == 0 && prev != -1) {
				result.add(new Interval(prev, event[0]));
			}
			count = (event[1] == 0) ? (count + 1) : (count - 1);
			prev = event[0];
		}
		return result;
	}

	// Time complexity is O(n*log(n)), where n is the total number of intervals.
	// Space complexity is O(n).

	private static class Interval {
		int start;
		int end;

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}

import java.util.Arrays;

// LeetCode #252 (Meeting Rooms).

// Given an array of meeting time intervals consisting of start and end times 
// [[s1, e1], [s2, e2], ...] (si < ei), determine if a person could attend all
// meetings.

public class MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> (a.start - b.start));
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort.
}

import java.util.Arrays;

// LeetCode #252 (Meeting Rooms).

// Given an array of meeting time intervals where intervals[i] = [start_i, end_i], determine if a person could attend all meetings.

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

	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort.
}

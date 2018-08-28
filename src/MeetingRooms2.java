import java.util.Arrays;
import java.util.PriorityQueue;

// LeetCode #253 (Meeting Rooms 2).

// Given an array of meeting time intervals consisting of start and end times
// [[s1, e1], [s2, e2], ...] (si < ei), find the minimum number of conference 
// rooms required.

public class MeetingRooms2 {

	// sort + heap
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, (a, b) -> (a.start - b.start));
		PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> (a.end - b.end));
		minHeap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval cur = minHeap.poll();
			// If cur and intervals[i] can use the same meeting room, merge them.
			if (cur.end <= intervals[i].start) {
				cur.end = intervals[i].end;
			} else {
				minHeap.offer(intervals[i]);
			}
			minHeap.offer(cur);
		}
		return minHeap.size();
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}

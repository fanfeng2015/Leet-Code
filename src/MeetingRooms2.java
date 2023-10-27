import java.util.Arrays;
import java.util.PriorityQueue;

// LeetCode #253 (Meeting Rooms 2).

// Given an array of meeting time intervals intervals where intervals[i] = [start_i, end_i], return the minimum number of conference
// rooms required.

public class MeetingRooms2 {

	// -------------------- 2018 --------------------
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

	// two arrays that are essentially the same as above
	public int minMeetingRooms2(Interval[] intervals) {
		int n = intervals.length;
		int[] starts = new int[n], ends = new int[n];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0, index = 0;
		for (int i = 0; i < n; i++) {
			if (starts[i] < ends[index]) {
				rooms++;
			} else {
				index++;
			}
		}
		return rooms;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// -------------------- 2023 --------------------
	// sort + heap
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> (a[1] - b[1]));
		minHeap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] cur = minHeap.poll();
			// If cur and intervals[i] can use the same meeting room (no overlap), merge
			// them.
			if (cur[1] <= intervals[i][0]) {
				cur[1] = intervals[i][1];
			} else { // there is an overlap
				minHeap.offer(intervals[i]);
			}
			minHeap.offer(cur);
		}
		return minHeap.size();
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// two arrays that are essentially the same as above
	public int minMeetingRooms2(int[][] intervals) {
		int n = intervals.length;
		int[] starts = new int[n], ends = new int[n];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0, index = 0;
		for (int i = 0; i < n; i++) {
			if (starts[i] < ends[index]) { // there is an overlap
				rooms++;
			} else { // this is the same as updating the end time in the above solution
				index++;
			}
		}
		return rooms;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	public int minMeetingRooms3(int[][] intervals) {
		int index = 0;
		Pair[] pairs = new Pair[2 * intervals.length];
		for (int[] interval : intervals) {
			pairs[index++] = new Pair(interval[0], true);
			pairs[index++] = new Pair(interval[1], false);
		}
		Arrays.sort(pairs);
		int result = 0, cur = 0;
		for (Pair pair : pairs) {
			cur = pair.start ? cur + 1 : cur - 1;
			result = Math.max(result, cur);
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	private class Pair implements Comparable<Pair> {
		int time;
		boolean start;

		Pair(int time, boolean start) {
			this.time = time;
			this.start = start;
		}

		@Override
		public int compareTo(Pair other) {
			if (this.time == other.time) {
				return this.start ? 1 : -1;
			}
			return this.time - other.time;
		}
	}
}

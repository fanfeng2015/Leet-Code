import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

	// -------------------- Sweep Line --------------------

	public int minMeetingRooms4(int[][] intervals) {
		int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] interval : intervals) {
			int left = interval[0], right = interval[1];
			start = Math.min(start, left);
			end = Math.max(end, right);
			map.put(left, map.getOrDefault(left, 0) + 1);
			map.put(right, map.getOrDefault(right, 0) - 1);
		}
		int count = 0, result = 0;
		for (int i = start; i <= end; i++) {
			count += map.getOrDefault(i, 0);
			result = Math.max(result, count);
		}
		return result;
	}

	// Time complexity is O(n+t).
	// Space complexity is O(t).

	public int minMeetingRooms5(int[][] intervals) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] interval : intervals) {
			int left = interval[0], right = interval[1];
			map.put(left, map.getOrDefault(left, 0) + 1);
			map.put(right, map.getOrDefault(right, 0) - 1);
		}
		int size = map.size(), rooms = 0, result = 0;
		for (int i = 0; i < size; i++) {
			Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
			rooms += entry.getValue();
			result = Math.max(result, rooms);
		}
		return result;
	}

	// Time complexity is O(t*log(t)).
	// Space complexity is O(t).

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LeetCode #616 (Add Bold Tag in String).

// Given a string s and a list of strings dict, you need to add a closed pair
// of bold tag <b> and </b> to wrap the substrings in s that exist in dict. 

// If two such substrings overlap, you need to wrap them together by only one
// pair of closed bold tag. Also, if two substrings wrapped by bold tags are
// consecutive, you need to combine them.

public class AddBoldTagInString {

	// Time complexity is O(m), where m = length of s.
	// Space complexity is O(1).
	public String addBoldTag(String s, String[] dict) {
		List<Interval> intervals = computeIntervals(s, dict);
		intervals = merge(intervals);

		int cur = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			Interval interval = (cur >= 0 && cur < intervals.size()) ? intervals.get(cur) : new Interval(-1, -1);
			if (i == interval.start) {
				sb.append("<b>");
			}
			sb.append(s.charAt(i));
			if (i == interval.end) {
				sb.append("</b>");
				cur++;
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n*m), where m = length of s, n = size of dict.
	// Space complexity is O(l), where l = size of intervals.
	private List<Interval> computeIntervals(String s, String[] dict) {
		List<Interval> intervals = new ArrayList<>();
		for (String t : dict) {
			int index = s.indexOf(t, -1);
			while (index != -1) {
				intervals.add(new Interval(index, index + t.length() - 1));
				index = s.indexOf(t, index + 1);
			}
		}
		return intervals;
	}

	// Time complexity is O(n*log(n)), where n = size of intervals.
	// Space complexity is O(n), because of merge sort.
	private List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> (a.start - b.start));
		List<Interval> result = new ArrayList<>();
		for (Interval interval : intervals) {
			Interval lastInterval = result.size() == 0 ? null : result.get(result.size() - 1);
			// Note the difference: interval.start - 1 because "if two substrings wrapped by
			// bold tags are consecutive, you need to combine them".
			if (lastInterval == null || lastInterval.end < interval.start - 1) {
				result.add(interval);
			} else {
				lastInterval.end = Math.max(lastInterval.end, interval.end);
			}
		}
		return result;
	}

}
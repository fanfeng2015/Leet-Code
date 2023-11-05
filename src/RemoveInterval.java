import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #1272 (Remove Interval).

// A set of real numbers can be represented as the union of several disjoint intervals, where each interval is in the form [a, b). A real 
// number x is in the set if one of its intervals [a, b) contains x (i.e. a <= x < b).

// You are given a sorted list of disjoint intervals intervals representing a set of real numbers as described above, where 
// intervals[i] = [ai, bi] represents the interval [ai, bi). You are also given another interval toBeRemoved.

// Return the set of real numbers with the interval toBeRemoved removed from intervals. In other words, return the set of real numbers such
// that every x in the set is in intervals but not in toBeRemoved. Your answer should be a sorted list of disjoint intervals as described 
// above.

public class RemoveInterval {

	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> result = new ArrayList<>();
		int left = toBeRemoved[0], right = toBeRemoved[1];
		for (int[] interval : intervals) {
			int a = interval[0], b = interval[1];
			if (Math.min(b, left) > a) {
				result.add(Arrays.asList(new Integer[] { a, Math.min(b, left) }));
			}
			if (Math.max(a, right) < b) {
				result.add(Arrays.asList(new Integer[] { Math.max(a, right), b }));
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

//      ------------------   remove
// ---
//    ---
//    -------------------------
//           ------
//           ---------------------
//                              ------
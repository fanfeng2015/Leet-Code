import java.util.ArrayList;
import java.util.List;

// LeetCode #118 (Pascal's Triangle).

// Given an integer numRows, return the first numRows of Pascal's triangle.

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) { // >= 1
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		result.get(0).add(1);
		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = result.get(i - 1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			for (int j = 1; j < prev.size(); j++) {
				cur.add(prev.get(j - 1) + prev.get(j));
			}
			cur.add(1);
			result.add(cur);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1), ignoring space needed for output.
}

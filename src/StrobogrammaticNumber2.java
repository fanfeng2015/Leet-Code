import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #247 (Strobogrammatic Number II).

// Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

public class StrobogrammaticNumber2 {

	// recursive
	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	public List<String> helper(int n, int end) {
		if (n == 0) {
			return Arrays.asList("");
		}
		if (n == 1) {
			return Arrays.asList("0", "1", "8");
		}
		List<String> result = new ArrayList<>();
		List<String> list = helper(n - 2, end);
		for (String str : list) {
			if (n != end) {
				result.add("0" + str + "0");
			}
			result.add("1" + str + "1");
			result.add("6" + str + "9");
			result.add("8" + str + "8");
			result.add("9" + str + "6");
		}
		return result;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).

	// iterative
	public List<String> findStrobogrammatic2(int n) {
		List<String> prev = new ArrayList<>(), cur = new ArrayList<>(), next;
		prev.add("");
		cur.add("0");
		cur.add("1");
		cur.add("8");
		for (int i = 2; i <= n; i++) {
			next = new ArrayList<>();
			for (String str : prev) {
				if (i < n) {
					next.add("0" + str + "0");
				}
				next.add("1" + str + "1");
				next.add("8" + str + "8");
				next.add("6" + str + "9");
				next.add("9" + str + "6");
			}
			prev = cur;
			cur = next;
		}
		return cur;
	}

	// Time complexity is O(n^3), due to string concatenation.
	// Space complexity is O(n^2).
}

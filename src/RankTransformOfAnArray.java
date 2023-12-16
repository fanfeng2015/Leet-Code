import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LeetCode #1331 (Rank Transform of an Array).

// Given an array of integers arr, replace each element with its rank.

// The rank represents how large the element is. The rank has the following rules:
// - Rank is an integer starting from 1.
// - The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
// - Rank should be as small as possible.

public class RankTransformOfAnArray {

	public int[] arrayRankTransform(int[] arr) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < copy.length; i++) {
			map.putIfAbsent(copy[i], map.size() + 1);
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = map.get(arr[i]);
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}

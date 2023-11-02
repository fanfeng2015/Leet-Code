import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsThatIntersectWithCars {

	public int numberOfPoints(List<List<Integer>> nums) {
		int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> num : nums) {
			int head = num.get(0), tail = num.get(1);
			start = Math.min(start, head);
			end = Math.max(end, tail);
			map.put(head, map.getOrDefault(head, 0) + 1);
			map.put(tail + 1, map.getOrDefault(tail + 1, 0) - 1);
		}
		int count = 0, result = 0;
		for (int i = start; i <= end; i++) {
			count += map.getOrDefault(i, 0);
			result = (count > 0) ? (result + 1) : result;
		}
		return result;
	}

	// Time complexity is O(n+l).
	// Space complexity is O(l).
}

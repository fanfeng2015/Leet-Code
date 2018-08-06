import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #356 (Line Reflection).

// Given n points on a 2D plane, find if there is such a line parallel to y-axis
// that reflect the given points.

public class LineReflection {

	public boolean isReflected(int[][] points) {
		// find min and max x coordinate
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int[] point : points) {
			min = Math.min(min, point[0]);
			max = Math.max(max, point[0]);
			set.add(Arrays.hashCode(point));
		}
		for (int[] point : points) {
			int targetX = min + max - point[0];
			if (!set.contains(Arrays.hashCode(new int[] { targetX, point[1] }))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

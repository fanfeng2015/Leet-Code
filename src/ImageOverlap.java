import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #835 (Image Overlap).

// Two images A and B are given, represented as binary, square matrices of the same size. A 
// binary matrix has only 0s and 1s as values.

// We translate one image however we choose (sliding it left, right, up, or down any number of
// units), and place it on top of the other image.  After, the overlap of this translation is
// the number of positions that have a 1 in both images.

// Note also that a translation does not include any kind of rotation.

// What is the largest possible overlap?

// Notes:
// 1. 1 <= A.length = A[0].length = B.length = B[0].length <= 30
// 2. 0 <= A[i][j], B[i][j] <= 1

public class ImageOverlap {

	public int largestOverlap(int[][] A, int[][] B) {
		int n = A.length;
		List<Integer> onesA = new ArrayList<>(), onesB = new ArrayList<>();
		for (int i = 0; i < n * n; i++) {
			if (A[i / n][i % n] == 1) {
				onesA.add(i / n * 100 + i % n);
			}
			if (B[i / n][i % n] == 1) {
				onesB.add(i / n * 100 + i % n);
			}
		}
		Map<Integer, Integer> diffToCount = new HashMap<>();
		for (int posA : onesA) {
			for (int posB : onesB) {
				Integer count = diffToCount.get(posA - posB);
				count = (count == null) ? 1 : count + 1;
				diffToCount.put(posA - posB, count);
			}
		}
		int max = 0;
		for (Integer count : diffToCount.values()) {
			max = Math.max(max, count);
		}
		return max;
	}

	// n = number of rows = number of columns
	// Time complexity is O(n^4), which is quadratic in input size.
	// Space complexity is O(n^2).

	// Note: When A and/or B are sparse, performance can be as good as O(n^2).
}

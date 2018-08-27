import java.util.HashMap;
import java.util.Map;

// LeetCode #454 (4 Sum II).

// Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there 
// are such that A[i] + B[j] + C[k] + D[l] is zero.

// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 

// All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be
// at most 2^31 - 1.

public class FourSum2 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				Integer count = map.get(A[i] + B[j]);
				count = count == null ? 1 : count + 1;
				map.put(A[i] + B[j], count);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				Integer count = map.get(0 - C[i] - D[j]);
				result += count == null ? 0 : count;
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

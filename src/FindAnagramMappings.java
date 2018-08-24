import java.util.HashMap;
import java.util.Map;

// LeetCode #760 (Find Anagram Mappings).

// Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is 
// made by randomizing the order of the elements in A.

// We want to find an index mapping P, from A to B. A mapping P[i] = j means the i-th
// element in A appears in B at index j.

// These lists A and B may contain duplicates. If there are multiple answers, output
// any of them.

public class FindAnagramMappings {

	public int[] anagramMappings(int[] A, int[] B) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			if (!map.containsKey(B[i])) {
				map.put(B[i], i);
			}
		}
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			result[i] = map.get(A[i]);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

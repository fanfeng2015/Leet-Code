// LeetCode #769 (Max Chunks To Make Sorted).

// Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the
// array into some number of "chunks" (partitions), and individually sort each chunk.  
// After concatenating them, the result equals the sorted array.

// What is the most number of chunks we could have made?

public class MaxChunksToMakeSorted {

	// Cut whenever maxSofar[i] equals sortedArr[i].
	// sortedArr[i] = i in this problem.
	public int maxChunksToSorted(int[] arr) {
		int n = arr.length;
		int max = 0, count = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i]);
			count = (max == i) ? count + 1 : count;
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

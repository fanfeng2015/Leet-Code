// LeetCode #370 (Range Addition).

// You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].

// You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should
// increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.

// Return arr after applying all the updates.

public class RangeAddition {

	// Solution 1
	// Time complexity is O(k*updates + length).
	// Space complexity is O(length).

	// Solution 2
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] map = new int[length + 1]; // length = 5, [0, 5]
		for (int[] update : updates) {
			int start = update[0], end = update[1], inc = update[2];
			map[start] += inc;
			map[end + 1] -= inc; // new int[length + 1] is to avoid index out of bound here
		}
		int sum = 0;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			sum += map[i];
			result[i] = sum;
		}
		return result;
	}

	// Time complexity is O(updates + length).
	// Space complexity is O(length).
}

// [0, 0, 0, 0, 0]
// [0, 2, 0, 0, -2]
// [0, 2, 3, 0, -2]
// [-2, 2, 3, 2, -2]

// [-2, 0, 3, 5, 3]
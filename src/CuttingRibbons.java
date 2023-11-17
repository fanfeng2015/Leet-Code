// LeetCode #1891 (Cutting Ribbons).

// You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k. You may 
// cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.

// For example, if you have a ribbon of length 4, you can:
// - Keep the ribbon of length 4,
// - Cut it into one ribbon of length 3 and one ribbon of length 1,
// - Cut it into two ribbons of length 2,
// - Cut it into one ribbon of length 2 and two ribbons of length 1, or
// - Cut it into four ribbons of length 1.

// Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as
// a result of cutting.

// Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of
// the same length.

public class CuttingRibbons {

	public int maxLength(int[] ribbons, int k) {
		int max = 0;
		for (int i = 0; i < ribbons.length; i++) {
			max = Math.max(max, ribbons[i]);
		}
		int lo = 1, hi = max;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int count = cutRibbons(ribbons, mid);
			if (count < k) { // then mid can't be the answer, at most answer is mid - 1
				hi = mid - 1;
			} else { // mid can be the answer, so you let them cross (lo <= hi) and return hi
				lo = mid + 1;
			}
		}
		return hi;
	}

	private int cutRibbons(int[] ribbons, int length) {
		int count = 0;
		for (int i = 0; i < ribbons.length; i++) {
			count += ribbons[i] / length;
		}
		return count;
	}

	// Time complexity is O(log(n) * n).
	// Space complexity is O(1).
}

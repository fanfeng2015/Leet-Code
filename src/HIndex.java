import java.util.Arrays;

// LeetCode #274 (H-Index).

// Given an array of citations (each citation is a non-negative integer) of a researcher, 
// write a function to compute the researcher's h-index.

// According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her
// N papers have at least h citations each, and the other N − h papers have no more than h citations each."

// For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and 
// each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with 
// at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

// Note: If there are several possible values for h, the maximum one is taken as the h-index.

public class HIndex {

	// Solution 1: For i = n, ..., 0, count how many papers have citations
	// greater than or equal to i, return the first i --> O(n^2) time, O(1)
	// space.

	// Solution 2: Sort first, then for i = n, ..., 0, run binary search to find
	// the index of the greatest number smaller than i, return the first i such
	// that index < n - i --> O(n * log(n)) time, O(1) space.
	public int hIndex(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		for (int i = n; i > 0; i--) {
			if (findLargestSmaller(citations, i) < n - i) {
				return i;
			}
		}
		return 0;
	}

	private int findLargestSmaller(int[] citations, int target) {
		int left = 0, right = citations.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (citations[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return (target <= citations[left]) ? left - 1 : (target <= citations[right]) ? left : right;
	}

	// Solution 3: Bucket sort
	public int hIndex2(int[] citations) {
		int n = citations.length;
		int[] counts = new int[n + 1]; // counts[i]: count of papers with i citations
		for (int i = 0; i < n; i++) {
			int index = Math.min(citations[i], n);
			counts[index] += 1;
		}
		int cur = 0;
		for (int i = n; i > 0; i--) {
			cur += counts[i];
			if (cur >= i) {
				return i;
			}
		}
		return 0;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

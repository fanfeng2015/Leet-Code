// LeetCode #896 (Monotonic Array).

// An array is monotonic if it is either monotone increasing or monotone 
// decreasing.

// An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An
// array A is monotone decreasing if for all i <= j, A[i] >= A[j].

// Return true if and only if the given array A is monotonic.

public class MonotonicArray {

	public boolean isMonotonic(int[] A) {
		return isMonotonic(A, true) || isMonotonic(A, false);
	}

	private boolean isMonotonic(int[] A, boolean increase) {
		for (int i = 0; i < A.length - 1; i++) {
			if ((increase && A[i] > A[i + 1]) || (!increase && A[i] < A[i + 1])) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

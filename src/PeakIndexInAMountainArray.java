// LeetCode #852 (Peak Index in a Mountain Array).

// Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// > arr[i + 1] > ... > arr[arr.length - 1].

// You must solve it in O(log(arr.length)) time complexity.

public class PeakIndexInAMountainArray {

	public int peakIndexInMountainArray(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid + 1]) { // peak is on the left, but can be mid
				right = mid;
			} else { // arr[mid] <= arr[mid + 1], mid is definitely not the peak
				left = mid + 1;
			}
		}
		return (arr[left] > arr[right]) ? left : right;
	}

	// Time Complexity is O(log(n)).
	// Space Complexity is O(1).
}

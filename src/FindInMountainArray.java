// LeetCode #1095 (Find in Mountain Array).

// Given a mountain array mountainArr, return the minimum index such that 
// mountainArr.get(index) == target. If such an index does not exist, return -1.

public class FindInMountainArray {

	interface MountainArray {
		public int get(int index);

		public int length();
	}

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int n = mountainArr.length();
		int index = peakIndexInMountainArray(mountainArr);
		int result = binarySearchAscending(0, index, target, mountainArr);
		return (result != -1) ? result : binarySearchDescending(index + 1, n - 1, target, mountainArr);
	}

	// #852 (Peak Index in a Mountain Array).
	private int peakIndexInMountainArray(MountainArray mountainArr) {
		int left = 0, right = mountainArr.length() - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mountainArr.get(mid) > mountainArr.get(mid + 1)) { // peak is on the left, but can be mid
				right = mid;
			} else { // arr[mid] <= arr[mid + 1], mid is definitely not the peak
				left = mid + 1;
			}
		}
		return (mountainArr.get(left) > mountainArr.get(right)) ? left : right;
	}

	private int binarySearchAscending(int left, int right, int target, MountainArray mountainArr) {
		// array != null && array.length > 1
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mountainArr.get(mid) == target) {
				return mid;
			} else if (mountainArr.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private int binarySearchDescending(int left, int right, int target, MountainArray mountainArr) {
		// array != null && array.length > 1
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mountainArr.get(mid) == target) {
				return mid;
			} else if (mountainArr.get(mid) > target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	// Time Complexity is O(log(n)).
	// Space Complexity is O(1).
}

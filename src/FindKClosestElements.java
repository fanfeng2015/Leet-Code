import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// LeetCode #658 (Find K Closest Elements).

// Given a sorted integer array arr, two integers k and x, return the k closest integers to x 
// in the array. The result should also be sorted in ascending order.

// An integer a is closer to x than an integer b if:
//  - |a - x| < |b - x|, or
//  - |a - x| == |b - x| and a < b

public class FindKClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		if (k > arr.length) {
			return Arrays.stream(arr).boxed().collect(Collectors.toList());
		}
		LinkedList<Integer> result = new LinkedList<>();
		int index = findClosestEqualOrSmaller(arr, x);
		int left = index, right = index + 1;
		for (int i = 0; i < k; i++) {
			int leftVal = (left < 0) ? Integer.MAX_VALUE : Math.abs(arr[left] - x);
			int rightVal = (right > arr.length - 1) ? Integer.MAX_VALUE : Math.abs(arr[right] - x);
			if (leftVal <= rightVal) {
				result.offerFirst(arr[left--]);
			} else {
				result.offerLast(arr[right++]);
			}
		}
		return result;
	}

	private int findClosestEqualOrSmaller(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else { // arr[mid] < target
				left = mid + 1;
			}
		}
		// left >= right
		return (arr[left] > target) ? (left - 1) : left;
	}

	// Time complexity is O(log(n) + k).
	// Space complexity is O(1).
}

// [1, 2, 3, 4, 7], x = 5  -> return 3;    l = r = 4
// [1, 2, 3, 4, 5], x = -1 -> return -1;   l = 0, r = -1
// [1, 2, 3, 4, 5], x = 7  -> return 4;    l = r = 4
// [1, 2, 3, 4, 5], x = 3  -> return 2;    

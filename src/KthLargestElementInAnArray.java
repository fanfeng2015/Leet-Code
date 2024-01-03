import java.util.PriorityQueue;

// LeetCode #215 (Kth Largest Element in an Array).

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

public class KthLargestElementInAnArray {

	// Solution 1: sort
	// - quick sort average case: O(n*log(n)) time, O(log(n)) space
	// - quick sort worst case: O(n^2) time, O(n) space

	// Solution 2: priority queue
	// - O(n*log(k)) time, O(k) space
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	// Solution 3: quick select
	// - average case: O(n) time, O(log(n)) space
	// - worst case: O(n^2) time, O(n) space
	public int findKthLargest2(int[] nums, int k) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int pivot = partition(nums, left, right);
			if (pivot < nums.length - k) {
				left = pivot + 1;
			} else if (pivot > nums.length - k) {
				right = pivot - 1;
			} else { // pivot == n - k
				return nums[pivot];
			}
		}
		return nums[nums.length - k];
	}

	private int partition(int[] nums, int left, int right) {
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivotValue = nums[pivotIndex];
		swap(nums, pivotIndex, right);
		int low = left, high = right - 1;
		while (low <= high) {
			if (nums[low] < pivotValue) {
				low++;
			} else if (nums[high] >= pivotValue) { // "=" can be placed in either if or else if
				high--;
			} else {
				swap(nums, low++, high--);
			}
		}
		// swap and return low -> equal values are all to the left of low
		// swap and return high -> equal values are all to the right of high
		swap(nums, low, right);
		return low;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Solution 4: count map
	// - O(n + m) time, O(m) space, where m is the range of nums
	public int findKthLargest4(int[] nums, int k) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		int[] freq = new int[max - min + 1];
		for (int i = 0; i < nums.length; i++) {
			int index = nums[i] - min; // offset by min
			freq[index]++;
		}
		k = nums.length - k;
		for (int i = 0; i < freq.length; i++) {
			if (k <= freq[i]) {
				return i + min;
			}
			k -= freq[i];
		}
		return -1;
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #315 (Count of Smaller Numbers After Self).

// You are given an integer array nums and you have to return a new counts array. 
// The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

public class CountOfSmallerNumbersAfterSelf {

	// Solution 1: Merge sort
	private static class Node {
		int index, val, count = 0;

		Node(int index, int val) {
			this.index = index;
			this.val = val;
		}

		Node(int index, int val, int count) {
			this.index = index;
			this.val = val;
			this.count = count;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		Node[] nodes = construct(nums);
		Node[] helper = new Node[nums.length];
		mergeSort(nodes, helper, 0, nums.length - 1);
		int[] array = new int[nums.length];
		for (int i = 0; i < nodes.length; i++) {
			Node node = nodes[i];
			array[node.index] = node.count;
		}
		List<Integer> result = new ArrayList<>();
		for (int i : array) {
			result.add(i);
		}
		return result;
	}

	private Node[] construct(int[] nums) {
		Node[] result = new Node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = new Node(i, nums[i]);
		}
		return result;
	}

	private void mergeSort(Node[] nodes, Node[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(nodes, helper, left, mid);
		mergeSort(nodes, helper, mid + 1, right);
		merge(nodes, helper, left, mid, right);
	}

	private void merge(Node[] nodes, Node[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = new Node(nodes[i].index, nodes[i].val, nodes[i].count);
		}
		int leftIndex = left, rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex].val <= helper[rightIndex].val) {
				nodes[left] = helper[leftIndex++];
				nodes[left].count += rightIndex - 1 - mid;
				left++;
			} else {
				nodes[left++] = helper[rightIndex++];
			}
		}
		while (leftIndex <= mid) {
			nodes[left] = helper[leftIndex++];
			nodes[left].count += rightIndex - 1 - mid;
			left++;
		}
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Solution 2: Binary search
	public List<Integer> countSmaller2(int[] nums) {
		Integer[] array = new Integer[nums.length];
		Arrays.fill(array, 0);
		List<Integer> result = new ArrayList<>(Arrays.asList(array));
		List<Integer> aux = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			// find the first number that is no less than nums[i]
			int left = 0, right = aux.size();
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (aux.get(mid) >= nums[i]) {
					right = mid;
				} else {
					// only with this can we do while (left < right),
					// instead of while (left < right - 1)
					left = mid + 1;
				}
			}
			// left == right, which indicates the position of the first number
			// >= nums[i], in other words, all numbers before left in aux are
			// less than nums[i]
			result.set(i, left);
			aux.add(left, nums[i]);
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Note: There is another solution, that uses BST.

	// However, if the BST is not balanced when it is constructed, time complexity
	// can become O(n^2), for input like [4, 3, 2, 1]. To optimize it, we can use
	// red-black tree, or AVL tree to balance the BST...

	// LaiCode: Get Count Array
	public int[] countArray(int[] array) {
		int[] indexArray = initialIndexArray(array);
		int[] countArray = new int[array.length];
		int[] helper = new int[array.length];
		mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
		return countArray;
	}

	private int[] initialIndexArray(int[] array) {
		int[] indices = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, indexArray, countArray, helper, left, mid);
		mergeSort(array, indexArray, countArray, helper, mid + 1, right);
		merge(array, indexArray, countArray, helper, left, mid, right);
	}

	private void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
		copyArray(indexArray, helper, left, right);
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			if (r > right || array[helper[l]] <= array[helper[r]]) {
				countArray[helper[l]] += (r - mid - 1);
				indexArray[cur++] = helper[l++];
			} else {
				indexArray[cur++] = helper[r++];
			}
		}
	}

	private void copyArray(int[] indexArray, int[] helper, int left, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = indexArray[i];
		}
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

}

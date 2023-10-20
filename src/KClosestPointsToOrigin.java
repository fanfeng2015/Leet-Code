import java.util.Arrays;
import java.util.PriorityQueue;

// LeetCode #973 (K Closest Points to Origin).

// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
// return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it
// is in).

public class KClosestPointsToOrigin {

	// Solution 1: priority queue
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (p1, p2) -> {
			return (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]);
		});
		for (int[] point : points) {
			maxHeap.offer(point);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = maxHeap.poll();
		}
		return result;
	}

	// Time complexity is O(n*log(k) + k*log(k)).
	// Space complexity is O(k).

	// Solution 2: quick select
	public int[][] kClosest2(int[][] points, int k) {
		int left = 0, right = points.length - 1;
		while (left < right) {
			int pivot = partition(points, left, right);
			if (pivot < k) {
				left = pivot + 1;
			} else if (pivot > k) {
				right = pivot - 1;
			} else { // pivot == k
				return Arrays.copyOfRange(points, 0, k);
			}
		}
		return Arrays.copyOfRange(points, 0, k);
	}

	private int partition(int[][] points, int left, int right) {
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivotValue = distance(points[pivotIndex]);
		swap(points, pivotIndex, right);
		int low = left, high = right - 1;
		while (low <= high) {
			if (distance(points[low]) < pivotValue) {
				low++;
			} else if (distance(points[high]) >= pivotValue) {
				high--;
			} else {
				swap(points, low++, high--);
			}
		}
		swap(points, low, right);
		return low;
	}

	private void swap(int[][] points, int left, int right) {
		int tempX = points[left][0], tempY = points[left][1];
		points[left][0] = points[right][0];
		points[left][1] = points[right][1];
		points[right][0] = tempX;
		points[right][1] = tempY;
	}

	private int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	// Time complexity is average case O(n), and worst case O(n^2).
	// Space complexity is average case O(log(n)), and worst case O(n).
}

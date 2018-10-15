import java.util.Collections;
import java.util.PriorityQueue;

// LeetCode #295 (Find Median from Data Stream).

// Median is the middle value in an ordered integer list. If the size of the list is even, 
// there is no middle value. So the median is the mean of the two middle value.

// For example:
// [2,3,4], the median is 3
// [2,3], the median is (2 + 3) / 2 = 2.5

// Design a data structure that supports the following two operations:
// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.

public class FindMedianFromDataStream {

	// In case of odd number of elements, always keep smallerHalf one element more
	// than largerHalf.
	private PriorityQueue<Integer> smallerHalf; // max heap
	private PriorityQueue<Integer> largerHalf; // min heap

	public FindMedianFromDataStream() {
		this.smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
		this.largerHalf = new PriorityQueue<>();
	}

	public void addNum(int value) {
		if (smallerHalf.size() == 0 || value < smallerHalf.peek()) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}
		if (smallerHalf.size() - largerHalf.size() == 2) {
			largerHalf.offer(smallerHalf.poll());
		} else if (largerHalf.size() - smallerHalf.size() == 1) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public double findMedian() {
		int n = smallerHalf.size() + largerHalf.size();
		if (n % 2 == 1) {
			return (double) smallerHalf.peek();
		} else {
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}

	// Time complexity is O(log(n)) for addNum(), and O(1) for findMedian().
	// Space complexity is O(n).
}

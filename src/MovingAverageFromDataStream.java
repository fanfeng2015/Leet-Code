// LeetCode #346 (Moving Average from Data Stream).

// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// Implement the MovingAverage class:
// - MovingAverage(int size) Initializes the object with the size of the window size.
// - double next(int val) Returns the moving average of the last size values of the stream.

public class MovingAverageFromDataStream {

	private int sum;
	private int cur;
	private int[] nums;

	public MovingAverageFromDataStream(int size) {
		nums = new int[size];
	}

	public double next(int val) {
		sum = sum - nums[cur % nums.length] + val;
		nums[cur % nums.length] = val;
		cur++;
		return (double) sum / (cur < nums.length ? cur : nums.length);
	}

}

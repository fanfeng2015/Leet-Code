// LeetCode #362 (Design Hit Counter).

// Design a hit counter which counts the number of hits received in the past 5 minutes.

// Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
// that calls are being made to the system in chronological order (ie, the timestamp is 
// monotonically increasing). You may assume that the earliest timestamp starts at 1.

// It is possible that several hits arrive roughly at the same time.

public class DesignHitCounter {

	private static final int TIME_FRAME = 300;

	private int[] timestamps;
	private int[] hits;

	public DesignHitCounter() {
		timestamps = new int[TIME_FRAME];
		hits = new int[TIME_FRAME];
	}

	public void hit(int timestamp) {
		int index = timestamp % TIME_FRAME;
		if (timestamps[index] != timestamp) {
			timestamps[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}

	public int getHits(int timestamp) {
		int count = 0;
		for (int i = 0; i < TIME_FRAME; i++) {
			if (timestamp - timestamps[i] < TIME_FRAME) {
				count += hits[i];
			}
		}
		return count;
	}

	// Time complexity is O(1) for hit(), but O(t) for getHits().
	// Space complexity is O(t).

	// Follow up: What if the number of hits per second could be very large? Does
	// your design scale?
	// Answer: Yes. Of course we need to worry about overflow.

	// Follow up: Could you solve the problem without storing all timestamps?
	// Answer: Use a FIFO queue.

/*
	private static final int TIME_FRAME = 300;

	private LinkedList<Integer> queue; // offerFirst(), pollLast(), peekLast()

	public DesignHitCounter() {
		this.queue = new LinkedList<>();
	}

	public void hit(int timestamp) {
		queue.offerFirst(timestamp);
	}

	public int getHits(int timestamp) {
		while (queue.size() > 0 && (timestamp - queue.peekLast()) >= TIME_FRAME) {
			queue.pollLast();
		}
		return queue.size();
	}
	
	// Time complexity is O(1) for hit(), but can be infinitely large for getHits().
	// Space complexity can be infinitely large.
	
	// Follow up: What if the number of hits per second could be very large? Does
	// your design scale?
	// Answer: No. Scalability is limited by the size of memory.
*/

}

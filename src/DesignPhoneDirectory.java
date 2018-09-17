import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// LeetCode #379 (Design Phone Directory).

// Design a Phone Directory which supports the following operations:

// 1. get: Provide a number which is not assigned to anyone.
// 2. check: Check if a number is available or not.
// 3. release: Recycle or release a number.

public class DesignPhoneDirectory {

/*
	private Queue<Integer> queue; // available numbers
	private Set<Integer> allocated;

	public DesignPhoneDirectory(int maxNumbers) {
		this.queue = new LinkedList<>();
		this.allocated = new HashSet<>();
		for (int i = 0; i < maxNumbers; i++) {
			queue.offer(i);
		}
	}

	public int get() {
		if (queue.isEmpty()) {
			return -1;
		}
		allocated.add(queue.peek());
		return queue.poll();
	}

	public boolean check(int number) { // assume number is valid
		return !allocated.contains(number);
	}

	public void release(int number) { // assume number is valid
		if (allocated.contains(number)) {
			allocated.remove(number);
			queue.offer(number);
		}
	}

	// Time complexity is O(n) to initialize, and O(1) for all three operations.
	// Space complexity is O(n).
*/
	
	// Follow up (Dropbox): Save memory usage.
	private final int MAX;
	private BitSet bs; // implemented using a long[] bits, the i-th bit is in bits[i/64] at i%64
	private int next; // next available number

	public DesignPhoneDirectory(int maxNumbers) {
		this.MAX = maxNumbers;
		this.bs = new BitSet(maxNumbers);
		this.next = 0;
	}

	public int get() {
		if (next == MAX) {
			return -1;
		}
		int result = next;
		bs.set(result); // O(1)
		next = bs.nextClearBit(result); // O(n)
		return result;
	}

	public boolean check(int number) { // assume number is valid
		return !bs.get(number);
	}

	public void release(int number) { // assume number is valid
		if (bs.get(number)) { // O(1)
			bs.clear(number); // O(1)
			next = Math.min(next, number);
		}
	}
	
	// Time complexity is O(1) to initialize, O(1) to check and to release, O(n) to get. 
	// Space complexity is O(n). However, the unit is 1 bit, compared with 8 bytes.
	

}

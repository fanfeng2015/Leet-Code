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
	
/*	
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
	
	// Time complexity is O(1) to initialize, O(1) to check and to release, and O(n) to get. 
	// Space complexity is O(n). However, the unit is 1 bit, instead of 8 bytes.

*/
	
/*
	// Follow up (Dropbox): Optimize get().
	private final int MAX;
	private BitSet bs; // implemented using a long[] bits, the i-th bit is in bits[i/64] at i%64

	public DesignPhoneDirectory(int maxNumbers) {
		this.MAX = maxNumbers;
		this.bs = new BitSet(2 * maxNumbers - 1);
	}

	// Note that get() might not return available number starting from 0.
	public int get() {
        if (bs.get(0)) {
            return -1;
        }
		int index = 0;
		while (index < MAX - 1) {
			if (!bs.get(2 * index + 1)) { // an available number exists in the left half
				index = 2 * index + 1;
			} else if (!bs.get(2 * index + 2)) { // an available number exists in the right half
				index = 2 * index + 2;
			} else {
				return -1;
			}
		}
		bs.set(index);
		updateTree(index);
		return index - (MAX - 1);
	}

	public boolean check(int number) { // assume number is valid
		return !bs.get(number + MAX - 1);
	}

	public void release(int number) { // assume number is valid
		if (bs.get(number + MAX - 1)) {
			bs.clear(number + MAX - 1);
			updateTree(number + MAX - 1);
		}
	}
	
	private void updateTree(int index) {
		while (index > 0) {
			int parent = (index - 1) / 2;
			if (index % 2 == 1) {
				if (bs.get(index) && bs.get(index + 1)) {
					bs.set(parent);
				} else {
					bs.clear(parent);
				}
			} else {
				if (bs.get(index - 1) && bs.get(index)) {
					bs.set(parent);
				} else {
					bs.clear(parent);
				}
			}
			index = parent;
		}
	}
	
	// Time complexity is O(1) to initialize, O(1) to check, and O(log(n)) to get and release. 
	// Space complexity is O(n). However, the unit is 2 bit, instead of 8 bytes.

*/
	
}

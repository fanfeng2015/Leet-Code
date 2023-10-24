import java.util.LinkedList;

// LeetCode #155 (Min Stack).

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// - MinStack() initializes the stack object.
// - void push(int val) pushes the element val onto the stack.
// - void pop() removes the element on the top of the stack.
// - int top() gets the top element of the stack.
// - int getMin() retrieves the minimum element in the stack.

// You must implement a solution with O(1) time complexity for each function.

public class MinStack {

	private LinkedList<Integer> stack;
	private LinkedList<Integer> min;

	public MinStack() {
		stack = new LinkedList<Integer>();
		min = new LinkedList<Integer>();
	}

	public void push(int element) {
		stack.offerFirst(element);
		min.offerFirst((min.isEmpty() || min.peekFirst() > element) ? element : min.peekFirst());
	}

	// Time complexity is O(1).

	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		min.pollFirst();
		return stack.pollFirst();
	}

	// Time complexity is O(1).

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	// Time complexity is O(1).

	public int getMin() {
		if (min.isEmpty()) {
			return -1;
		}
		return min.peekFirst();
	}

	// Time complexity is O(1).

}

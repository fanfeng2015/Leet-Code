import java.util.LinkedList;

// LeetCode #225 (Implement Stack Using Queues).

// Implement stack using queues.

public class ImplementStackUsingQueues {

	// Can only use offerLast(), pollFirst() and peekFirst().
	LinkedList<Integer> queue = new LinkedList<>();

	public ImplementStackUsingQueues() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.offerLast(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.offerLast(queue.pollFirst());
		}
	}

	public int pop() {
		return queue.pollFirst();
	}

	public int top() {
		return queue.peekFirst();
	}

	public boolean empty() {
		return queue.size() == 0;
	}

	// Time complexity is O(n) for push, and O(1) for pop and top.

	public void push2(int x) {
		queue.offerLast(x);
	}

	public int pop2() {
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.offerLast(queue.pollFirst());
		}
		return queue.pollFirst();
	}

	public int top2() {
		int result = pop2();
		queue.offerLast(result);
		return result;
	}

	public boolean empty2() {
		return queue.size() == 0;
	}

	// Time complexity is O(1) for push, and O(n) for pop and top.
}

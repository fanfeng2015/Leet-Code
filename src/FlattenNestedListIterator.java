import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// LeetCode #341 (Flatten Nested List Iterator).

// Given a nested list of integers, implement an iterator to flatten it.

// Each element is either an integer, or a list -- whose elements may also
// be integers or other lists.

public class FlattenNestedListIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack = new Stack<>();

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if (cur.isInteger()) {
				return true;
			} else {
				stack.pop();
				List<NestedInteger> list = cur.getList();
				for (int i = list.size() - 1; i >= 0; i--) {
					stack.push(list.get(i));
				}
			}
		}
		return false;
	}

}

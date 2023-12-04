import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// LeetCode #341 (Flatten Nested List Iterator).

// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be 
// integers or other lists. Implement an iterator to flatten it.

// Implement the NestedIterator class:
// - NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// - int next() Returns the next integer in the nested list.
// - boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

// Your code will be tested with the following pseudocode:
//   initialize iterator with nestedList
//   res = []
//   while iterator.hasNext()
//     append iterator.next() to the end of res
//   return res

// If res matches the expected flattened list, then your code will be judged as correct.

public class FlattenNestedListIterator implements Iterator<Integer> {

	LinkedList<NestedInteger> stack = new LinkedList<>();

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.offerLast(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pollLast().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger cur = stack.peekLast();
			if (cur.isInteger()) {
				return true;
			} else {
				stack.pollLast();
				for (int i = cur.getList().size() - 1; i >= 0; i--) {
					stack.offerLast(cur.getList().get(i));
				}
			}
		}
		return false;
	}
}

import java.util.List;

public interface NestedInteger {

	// Returns true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// Returns the single integer that this NestedInteger holds, if it holds a
	// single integer, or null otherwise.
	public Integer getInteger();

	// Returns the nested list that this NestedInteger holds, if it holds a nested
	// list, or null otherwise.
	public List<NestedInteger> getList();

}

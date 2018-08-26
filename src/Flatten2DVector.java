import java.util.Iterator;
import java.util.List;

// LeetCode #251 (Flatten 2D Vector).

// Implement an iterator to flatten a 2d vector.

public class Flatten2DVector implements Iterator<Integer> {

	private int row, col;
	List<List<Integer>> vec2d;

	public Flatten2DVector(List<List<Integer>> vec2d) {
		this.row = 0;
		this.col = 0;
		this.vec2d = vec2d;
	}

	@Override
	public Integer next() {
		Integer result = vec2d.get(row).get(col++);
		if (col == vec2d.get(row).size()) {
			row++;
			col = 0;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		while (row < vec2d.size() && col == vec2d.get(row).size()) {
			row++;
			col = 0;
		}
		return row < vec2d.size() && col < vec2d.get(row).size();
	}

}

// LeetCode #223 (Rectangle Area).

// Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by
// the two rectangles.

// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

// The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

public class RectangleArea {

	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int areaA = (ax2 - ax1) * (ay2 - ay1);
		int areaB = (bx2 - bx1) * (by2 - by1);
		if (ax2 < bx1 || bx2 < ax1 || ay1 > by2 || by1 > ay2) { // 0 overlap
			return areaA + areaB;
		}
		int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		int height = Math.min(ay2, by2) - Math.max(ay1, by1);
		return areaA + areaB - height * width;
	}

	// Time complexity is O(1).
	// Space complexity is O(1).
}

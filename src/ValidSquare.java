import java.util.Arrays;

// LeetCode #593 (Valid Square).

// Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

// The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

// A valid square has four equal sides with positive length and four equal angles (90-degree angles).

public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] p = { p1, p2, p3, p4 };
		Arrays.sort(p, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
		boolean sides = dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3])
				&& dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0]);
		boolean diag = dist(p[0], p[3]) == dist(p[1], p[2]);
		return sides && diag;
	}

	private double dist(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}

	// Time complexity is O(1).
	// Space complexity is O(1).
}

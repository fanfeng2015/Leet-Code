// LeetCode #276 (Paint Fence).

// You are painting a fence of n posts with k different colors. You must paint the posts following these rules:

// - Every post must be painted exactly one color.
// - There cannot be three or more consecutive posts with the same color.
// - Given the two integers n and k, return the number of ways you can paint the fence.

public class PaintFence {

	public int numWays(int n, int k) {
		// diff or same here means the i-th fence uses different/same color as the
		// (i-1)-th fence
		int prevDiff = k, prevSame = 0;
		int curDiff = 0, curSame = 0;
		for (int i = 1; i < n; i++) {
			curDiff = prevDiff * (k - 1) + prevSame * (k - 1);
			curSame = prevDiff * 1 + prevSame * 0;
			prevDiff = curDiff;
			prevSame = curSame;
		}
		return prevDiff + prevSame;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

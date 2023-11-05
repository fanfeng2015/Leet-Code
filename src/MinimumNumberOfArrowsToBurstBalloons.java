import java.util.Arrays;

// LeetCode #452 (Minimum Number of Arrows to Burst Balloons).

// There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array
// points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the
// exact y-coordinates of the balloons.

// Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and
// xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps
// traveling up infinitely, bursting any balloons in its path.

// Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

public class MinimumNumberOfArrowsToBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> (a[0] < b[0]) ? -1 : 1);
		int count = 0, end = Integer.MAX_VALUE; // minimum end of all balloons that can be bursted by the current arrow
		for (int i = 0; i < points.length; i++) {
			end = Math.min(end, points[i][1]);
			if (points[i][0] > end) {
				count++;
				end = points[i][1];
			}
		}
		return count + 1;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O()
}

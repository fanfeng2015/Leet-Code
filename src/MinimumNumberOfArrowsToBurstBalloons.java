import java.util.Arrays;

// LeetCode #452 (Minimum Number of Arrows to Burst Balloons).

// There are a number of spherical balloons spread in two-dimensional space. For each balloon, 
// provided input is the start and end coordinates of the horizontal diameter. Since it's 
// horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the
// diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

// An arrow can be shot up exactly vertically from different points along the x-axis. A balloon
// with xstart and xend bursts by an arrow shot at x if xstart <= x <= xend. There is no limit to
// the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely. 

// The problem is to find the minimum number of arrows that must be shot to burst all balloons.

public class MinimumNumberOfArrowsToBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		int n = points.length;
		if (n == 0) {
			return 0;
		}
		Arrays.sort(points, (a, b) -> (a[0] - b[0]));
		int count = 0;
		int end = Integer.MAX_VALUE; // minimum end of all balloons that can be bursted by the current arrow
		for (int i = 0; i < n; i++) {
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

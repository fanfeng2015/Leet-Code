import java.util.PriorityQueue;

// LeetCode #774 (Minimize Max Distance to Gas Station).

// On a horizontal number line, we have gas stations at positions stations[0], stations[1],
// ..., stations[N-1], where N = stations.length.

//  Now, we add K more gas stations so that D, the maximum distance between adjacent gas 
// stations, is minimized.

// Return the smallest possible value of D.

// Notes:
// 1. stations.length will be an integer in range [10, 2000].
// 2. stations[i] will be an integer in range [0, 10^8].
// 3. K will be an integer in range [1, 10^6].
// 4. Answers within 10^-6 of the true value will be accepted as correct.

public class MinimizeMaxDistanceToGasStation {

	// Solution 1: priority queue (TLE)
	public double minmaxGasDist(int[] stations, int K) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(a, b) -> ((double) b[0] / b[1]) < (double) a[0] / a[1] ? -1 : 1);
		for (int i = 0; i < stations.length - 1; i++) {
			maxHeap.offer(new int[] { stations[i + 1] - stations[i], 1 });
		}
		for (int i = 0; i < K; i++) {
			int[] cur = maxHeap.poll();
			cur[1]++;
			maxHeap.offer(cur);
		}
		int[] max = maxHeap.peek();
		return (double) max[0] / max[1];
	}

	// Time complexity is O(n*log(n) + k*log(n)).
	// Space complexity is O(n).

	// Solution 2: binary search
	public double minmaxGasDist2(int[] stations, int K) {
		double left = 0, right = 1e8;
		while (right - left > 1e-6) {
			double mid = left + (right - left) / 2;
			if (possible(stations, K, mid))
				right = mid;
			else
				left = mid;
		}
		return left;
	}

	// Returns whether it is possible to make all adjacent stations <= D apart from
	// each other by adding <= K gas stations.
	public boolean possible(int[] stations, int K, double D) {
		int needed = 0;
		for (int i = 0; i < stations.length - 1; i++) {
			needed += (int) ((stations[i + 1] - stations[i]) / D);
		}
		return needed <= K;
	}

}

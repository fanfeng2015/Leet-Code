import java.util.Arrays;
import java.util.PriorityQueue;

// LeetCode #857 (Minimum Cost to Hire K Workers).

// There are N workers. The i-th worker has a quality[i] and a minimum wage expectation
// wage[i].

// Now we want to hire exactly K workers to form a paid group. When hiring a group of K
// workers, we must pay them according to the following rules:

// 1. Every worker in the paid group should be paid in the ratio of their quality compared'
// to other workers in the paid group.
// 2. Every worker in the paid group must be paid at least their minimum wage expectation.

// Return the least amount of money needed to form a paid group satisfying the above conditions.

// Notes:
// 1. 1 <= K <= N <= 10000, where N = quality.length = wage.length
// 2. 1 <= quality[i] <= 10000
// 3. 1 <= wage[i] <= 10000
// 4. Answers within 10^(-5) of the correct answer will be considered correct.

public class MinimumCostToHireKWorkers {

	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		int n = quality.length;
		double[][] workers = new double[n][2]; // [ ratio, quality ]
		for (int i = 0; i < n; i++) {
			workers[i] = new double[] { (double) wage[i] / quality[i], (double) quality[i] };
		}
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // sort by ratio
		double result = Double.MAX_VALUE, qualitySum = 0;
		PriorityQueue<Double> maxHeap = new PriorityQueue<>(K, (a, b) -> Double.compare(b, a)); // of quality
		for (int i = 0; i < n; i++) {
			qualitySum += workers[i][1];
			maxHeap.offer(workers[i][1]);
			if (maxHeap.size() > K) {
				qualitySum -= maxHeap.poll();
			}
			if (maxHeap.size() == K) {
				result = Math.min(result, workers[i][0] * qualitySum);
			}
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}

// LeetCode #1101 (Capacity To Ship Packages Within D Days).

// A conveyor belt has packages that must be shipped from one port to another within days days.

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship
// with packages on the conveyor belt (in the order given by weights). We may not load more weight
// than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor
// belt being shipped within days days.

public class CapacityToShipPackagesWithinDDays {

	public int shipWithinDays(int[] weights, int days) {
		int sum = 0, max = 0;
		for (int w : weights) {
			sum += w;
			max = Math.max(max, w);
		}
		int capacity = Math.max(sum / days, max);
		int curSum = 0, numDays = 1;
		for (; capacity <= sum; capacity++) {
			for (int i = 0; i < weights.length; i++) {
				if (curSum + weights[i] <= capacity) {
					curSum += weights[i];
				} else {
					curSum = weights[i];
					numDays++; // can break early
				}
			}
			if (numDays <= days) {
				return capacity;
			}
			curSum = 0;
			numDays = 1;
		}
		return -1; // shouldn't reach here
	}

	// Time complexity is O(n*sum).
	// Space complexity is O(1).

	// can run binary search on all possible capacity values
	public int shipWithinDays2(int[] weights, int days) {
		int sum = 0, max = 0;
		for (int w : weights) {
			sum += w;
			max = Math.max(max, w);
		}
		int left = Math.max(sum / days, max), right = sum;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int numDays = daysNeededToShip(weights, mid);
			if (numDays > days) {
				left = mid + 1;
			} else if (numDays <= days) {
				right = mid;
			}
		}
		return right;
	}

	private int daysNeededToShip(int[] weights, int capacity) {
		int curSum = 0, numDays = 1;
		for (int i = 0; i < weights.length; i++) {
			if (curSum + weights[i] <= capacity) {
				curSum += weights[i];
			} else {
				curSum = weights[i];
				numDays++; // can return numDays early
			}
		}
		return numDays;
	}

	// Time complexity is O(n*log(sum)).
	// Space complexity is O(1).
}

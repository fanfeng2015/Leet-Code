// LeetCode #683 (K Empty Slots).

// There is a garden with N slots. In each slot, there is a flower. 

// The N flowers will bloom one by one in N days. In each day, there will be
// exactly one flower blooming and it will be in the status of blooming since then.

// Given an array flowers consists of number from 1 to N. Each number in the array 
// represents the place where the flower will open in that day.

// For example, flowers[i] = x means that the unique flower that blooms at day i+1 
// will be at position x, where i+1 and x will be in the range from 1 to N.

// Also given an integer k, you need to output in which day there exists two flowers 
// in the status of blooming, and also the number of flowers between them is k and 
// these flowers are not blooming.

// If there isn't such day, output -1.

public class KEmptySlots {

	public int kEmptySlots(int[] flowers, int k) {
		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			days[flowers[i] - 1] = i + 1;
		}
		int left = 0, right = k + 1;
		int min = Integer.MAX_VALUE;
		for (int i = left + 1; right < flowers.length; i++) {
			if (days[i] > days[left] && days[i] > days[right]) {
				continue;
			}
			if (i == right) { // valid sliding window
				min = Math.min(min, Math.max(days[left], days[right]));
			}
			left = i;
			right = left + k + 1;

		}
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Follow up (Google 2019 University Grad OA):
	// Given (int[] flowers, int k, and int m), return the latest day where there
	// are exactly m groups, each group having >= k continuous blooming flowers.
}

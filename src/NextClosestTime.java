import java.util.HashSet;
import java.util.Set;

// LeetCode #681 (Next Closest Time).

// Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
// There is no limit on how many times a digit can be reused.

// You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34",
// "12:9" are all invalid.

public class NextClosestTime {

	public String nextClosestTime(String time) {
		Set<Integer> digits = new HashSet<>();
		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) != ':') {
				digits.add(time.charAt(i) - '0');
			}
		}
		int minDiff = 24 * 60;
		int start = 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3));
		int result = start;
		for (int a : digits) {
			for (int b : digits) {
				int hour = 10 * a + b;
				if (hour < 24) {
					for (int c : digits) {
						for (int d : digits) {
							int minute = 10 * c + d;
							if (minute < 60) {
								int newDiff = Math.floorMod(60 * hour + minute - start, 24 * 60); // floorMod
								if (newDiff > 0 && newDiff < minDiff) {
									minDiff = newDiff;
									result = 60 * hour + minute;
								}
							}
						}
					}
				}
			}
		}
		String hour = (result / 60 < 10) ? ("0" + result / 60) : ("" + result / 60);
		String minute = (result % 60 < 10) ? ("0" + result % 60) : ("" + result % 60);
		return hour + ":" + minute;
	}

	// There are at most 4 * 4 * 4 * 4 = 256 possible times.
	// Time complexity is O(1).
	// Space complexity is O(1).
	
	// How about returning the previous closest time?
	// int newDiff = Math.floorMod(start - (60 * hour + minute), 24 * 60); // floorMod
}
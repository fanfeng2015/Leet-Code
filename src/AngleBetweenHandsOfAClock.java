// LeetCode #1344 (Angle Between Hands of a Clock).

// Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

// Answers within 10-5 of the actual value will be accepted as correct.

public class AngleBetweenHandsOfAClock {

	public double angleClock(int hour, int minutes) {
		double angle = Math.abs(6 * minutes - (hour % 12) * 30 - (double) minutes / 2);
		angle = Math.min(angle, 360.0 - angle);
		return angle;
	}

	// Time complexity is O(1).
	// Space complexity is O(1).
}

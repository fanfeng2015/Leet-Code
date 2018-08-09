// LeetCode #551 (Student Attendance Record I).

// You are given a string representing an attendance record for a student. 

// The record only contains the following three characters:
// 'A' : Absent.
// 'L' : Late.
// 'P' : Present.

// A student could be rewarded if his attendance record doesn't contain more
// than one 'A' (absent) or more than two continuous 'L' (late).

// You need to return whether the student could be rewarded according to his
// attendance record.

public class StudentAttendanceRecord {

	public boolean checkRecord(String s) {
		boolean absent = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				if (absent) {
					return false;
				}
				absent = true;
			} else if (i < s.length() - 1 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

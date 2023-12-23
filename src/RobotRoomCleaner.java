import java.util.HashSet;
import java.util.Set;

// LeetCode #489 (Robot Room Cleaner).

// You are controlling a robot that is located somewhere in a room. The room is modeled as an m x n binary grid where 0 represents a 
// wall and 1 represents an empty slot.

// The robot starts at an unknown location in the room that is guaranteed to be empty, and you do not have access to the grid, but you
// can move the robot using the given API Robot.

// You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room). The robot with the four given
// APIs can move forward, turn left, or turn right. Each turn is 90 degrees.

// When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.

// Design an algorithm to clean the entire room using the following APIs:
//   interface Robot {
//     // returns true if next cell is open and robot moves into the cell.
//     // returns false if next cell is obstacle and robot stays on the current cell.
//     boolean move();
//
//     // Robot will stay on the same cell after calling turnLeft/turnRight.
//     // Each turn will be 90 degrees.
//     void turnLeft();
//     void turnRight();
//
//     // Clean the current cell.
//     void clean();
//   }

// Note that the initial direction of the robot will be facing up. You can assume all four edges of the grid are all surrounded by a
// wall.

// Custom testing:
// The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In
// other words, you must control the robot using only the four mentioned APIs without knowing the room layout and the initial robot's
// position.

public class RobotRoomCleaner {

	// U, R, D, L
	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>();
		visited.add("0#0");
		DFS(robot, visited, 0, 0, 0);
	}

	private void DFS(Robot robot, Set<String> visited, int row, int col, int curDir) {
		robot.clean();
		for (int i = 0; i < 4; i++) {
			int nextDir = (curDir + i) % 4;
			int nextRow = row + DIRECTIONS[nextDir][0], nextCol = col + DIRECTIONS[nextDir][1];
			// currently facing nextDir
			if (!visited.contains(nextRow + "#" + nextCol) && robot.move()) {
				visited.add(nextRow + "#" + nextCol);
				DFS(robot, visited, nextRow, nextCol, nextDir);
			}
			robot.turnRight();
		}
		// return to the previous cell
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

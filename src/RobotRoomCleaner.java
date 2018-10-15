import java.util.HashSet;
import java.util.Set;

// LeetCode #489 (Robot Room Cleaner).

// Given a robot cleaner in a room modeled as a grid.

// Each cell in the grid can be empty or blocked.

// The robot cleaner with 4 given APIs can move forward, turn left or turn right. 
// Each turn it made is 90 degrees.

// When it tries to move into a blocked cell, its bumper sensor detects the obstacle
// and it stays on the current cell.

// Notes:
// 1. The input is only given to initialize the room and the robot's position internally. 
//    You must solve this problem "blindfolded". In other words, you must control the robot
//    using only the mentioned 4 APIs, without knowing the room layout and the initial robot's
//    position.
// 2. The robot's initial position will always be in an accessible cell.
// 3. The initial direction of the robot will be facing up.
// 4. All accessible cells are connected, which means the all cells marked as 1 will be accessible
//    by the robot.
// 5. Assume all four edges of the grid are all surrounded by wall.

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

}

// LeetCode #490 (The Maze).

// There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty 
// spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose
// the next direction.

//  Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and 
// destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

// You may assume that the borders of the maze are all walls (see examples).

public class TheMaze {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public boolean hasPath(int[][] maze, int[] from, int[] to) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return DFS(visited, maze, from[0], from[1], to[0], to[1]);
	}

	private boolean DFS(boolean[][] visited, int[][] maze, int curRow, int curCol, int toRow, int toCol) {
		int m = maze.length, n = maze[0].length;
		if (visited[curRow][curCol]) {
			return false;
		}
		if (curRow == toRow && curCol == toCol) {
			return true;
		}
		visited[curRow][curCol] = true;
		for (int[] direction : DIRECTIONS) { // go as far as possible until a wall is hit
			int nextRow = curRow + direction[0], nextCol = curCol + direction[1];
			while (!indexOutOfBound(nextRow, nextCol, m, n) && maze[nextRow][nextCol] == 0) {
				nextRow += direction[0];
				nextCol += direction[1];
			}
			if (DFS(visited, maze, nextRow - direction[0], nextCol - direction[1], toRow, toCol)) {
				return true;
			}
		}
		return false;
	}

	private boolean indexOutOfBound(int row, int col, int m, int n) {
		return row < 0 || row >= m || col < 0 || col >= n;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

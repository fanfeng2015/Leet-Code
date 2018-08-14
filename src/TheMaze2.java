import java.util.Arrays;

// LeetCode #505 (The Maze II).

// There is a ball in a maze with empty spaces and walls. The ball can go through
// empty spaces by rolling up, down, left or right, but it won't stop rolling until
// hitting a wall. When the ball stops, it could choose the next direction.

// Given the ball's start position, the destination and the maze, find the shortest
// distance for the ball to stop at the destination. The distance is defined by the
// number of empty spaces traveled by the ball from the start position (excluded) to
// the destination (included). If the ball cannot stop at the destination, return -1.

// The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty
// space. You may assume that the borders of the maze are all walls. The start and 
// destination coordinates are represented by row and column indexes.

public class TheMaze2 {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int shortestDistance(int[][] maze, int[] from, int[] to) {
		int m = maze.length, n = maze[0].length;
		int[][] distance = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[from[0]][from[1]] = 0;
		DFS(distance, maze, from[0], from[1], to[0], to[1]);
		return (distance[to[0]][to[1]] == Integer.MAX_VALUE) ? -1 : distance[to[0]][to[1]];
	}

	private void DFS(int[][] distance, int[][] maze, int curRow, int curCol, int toRow, int toCol) {
		int m = maze.length, n = maze[0].length;
		for (int[] direction : DIRECTIONS) { // go as far as possible until a wall is hit
			int count = 1;
			int nextRow = curRow + direction[0], nextCol = curCol + direction[1];
			while (!indexOutOfBound(nextRow, nextCol, m, n) && maze[nextRow][nextCol] == 0) {
				count++;
				nextRow += direction[0];
				nextCol += direction[1];
			}
			count--;
			nextRow -= direction[0];
			nextCol -= direction[1];
			if (distance[curRow][curCol] + count < distance[nextRow][nextCol]) {
				distance[nextRow][nextCol] = distance[curRow][curCol] + count;
				DFS(distance, maze, nextRow, nextCol, toRow, toCol);
			}
		}
	}

	private boolean indexOutOfBound(int row, int col, int m, int n) {
		return row < 0 || row >= m || col < 0 || col >= n;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

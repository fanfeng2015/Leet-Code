import java.util.LinkedList;

// LeetCode #735 (Asteroid Collision).

// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, 
// negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are 
// the same size, both will explode. Two asteroids moving in the same direction will never meet.

public class AsteroidCollision {

	public int[] asteroidCollision(int[] asteroids) {
		int index = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		while (index < asteroids.length) {
			if (stack.isEmpty() || !(stack.peekLast() > 0 && asteroids[index] < 0)) {
				stack.offerLast(asteroids[index++]);
			} else if (Math.abs(stack.peekLast()) < Math.abs(asteroids[index])) {
				stack.pollLast();
			} else if (Math.abs(stack.peekLast()) == Math.abs(asteroids[index])) {
				stack.pollLast();
				index++;
			} else {
				index++;
			}
		}
		return stack.stream().mapToInt(Integer::intValue).toArray();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

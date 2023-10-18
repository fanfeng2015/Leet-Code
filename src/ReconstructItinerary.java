import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// LeetCode #332 (Reconstruct Itinerary).

// You are given a list of airline tickets where tickets[i] = [from_i, to_i] represent the departure and the
// arrival airports of one flight. Reconstruct the itinerary in order and return it.

// All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If
// there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
// when read as a single string.

// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only
// once.

public class ReconstructItinerary {

	HashMap<String, LinkedList<String>> flightMap = new HashMap<>(); // { origin: [ destinations ] }
	HashMap<String, boolean[]> visitBitmap = new HashMap<>(); // to track whether the itinerary has been used
	int flights = 0;
	LinkedList<String> result = new LinkedList<String>();

	public List<String> findItinerary(List<List<String>> tickets) {
		// Step 1). build the graph
		for (List<String> ticket : tickets) {
			String origin = ticket.get(0);
			String dest = ticket.get(1);
			if (!this.flightMap.containsKey(origin)) {
				this.flightMap.put(origin, new LinkedList<String>());
			}
			this.flightMap.get(origin).add(dest);
		}

		// Step 2). order the destinations and init the visit bitmap
		for (Map.Entry<String, LinkedList<String>> entry : this.flightMap.entrySet()) {
			Collections.sort(entry.getValue()); // so that destinations are in lexical order
			this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
		}

		this.flights = tickets.size();
		LinkedList<String> route = new LinkedList<String>(); // current route
		route.add("JFK");

		// Step 3). run dfs
		this.dfs("JFK", route);
		return this.result;
	}

	@SuppressWarnings("unchecked")
	private boolean dfs(String origin, LinkedList<String> route) {
		if (route.size() == this.flights + 1) {
			this.result = (LinkedList<String>) route.clone();
			return true;
		}
		if (!this.flightMap.containsKey(origin)) {
			return false;
		}

		LinkedList<String> destinations = this.flightMap.get(origin);
		boolean[] bitmap = this.visitBitmap.get(origin);
		for (int i = 0; i < destinations.size(); i++) {
			String dest = destinations.get(i);
			if (!bitmap[i]) {
				bitmap[i] = true;
				route.add(dest);
				boolean found = this.dfs(dest, route);
				route.pollLast();
				bitmap[i] = false;
				if (found) {
					return true;
				}
			}
		}

		return false;
	}

	// V: # of cities, E: # of flights/tickets, d: # of destinations, bounded by V
	// Time complexity is O(V+E + d*log(d) + d^E).
	// Space complexity is O(V+E).

	public List<String> findItinerary2(List<List<String>> tickets) {
		// Step 1). build the graph first
		for (List<String> ticket : tickets) {
			String origin = ticket.get(0);
			String dest = ticket.get(1);
			if (!this.flightMap.containsKey(origin)) {
				this.flightMap.put(origin, new LinkedList<String>());
			}
			this.flightMap.get(origin).add(dest);
		}

		// Step 2). order the destinations
		this.flightMap.forEach((key, value) -> Collections.sort(value));

		// Step 3). post-order DFS
		this.dfs2("JFK");
		return this.result;
	}

	private void dfs2(String origin) {
		if (this.flightMap.containsKey(origin)) {
			LinkedList<String> destList = this.flightMap.get(origin);
			while (!destList.isEmpty()) {
				// while visiting each edge, remove it from graph
				String dest = destList.pollFirst();
				dfs2(dest);
			}
		}
		// add origin to the head
		this.result.offerFirst(origin);
	}

	// Time complexity is O(V+E + d*log(d) + d^E). Not 100% sure.
	// Space complexity is O(V+E).
}

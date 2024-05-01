class Solution {
    public int countPaths(int n, int[][] roads) {
        NumberOfWays now = new NumberOfWays(n,roads.length,roads);
        return now.getResult();
    }
}

class Node {
	long id;
	long distance;

	Node(long id, long distance) {
		this.id = id;
		this.distance = distance;
	}

}

class NumberOfWays {
	private int n;
	private int m;
	private int[][] edges;
	private int noOfWays;
	private List<List<Node>> graph;

	NumberOfWays(int n, int m, int[][] edges) {
		this.n = n;
		this.m = m;
		this.edges = edges;
		this.noOfWays = 1;

		if (isValid()) {
			this.graph = new ArrayList<>();
			init();
			constructGraph();
			findNoOfWays();
		}
	}

	private boolean isValid() {
		return this.n != 0 && this.m != 0 && this.edges != null && this.edges.length != 0 && this.edges[0].length != 0;
	}

	private void init() {
		for (int i = 0; i < this.n; i++) {
			this.graph.add(new ArrayList<>());
		}
	}

	private void constructGraph() {
		for (int edge[] : this.edges) {
			this.graph.get(edge[0]).add(new Node(edge[1], edge[2]));
			this.graph.get(edge[1]).add(new Node(edge[0], edge[2]));
		}

	}

	private void findNoOfWays() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong (p -> p.distance));
		long[] distance = new long[this.n];
		int[] way = new int[this.n];

		Arrays.fill(distance, Long.MAX_VALUE);
		Arrays.fill(way, 0);

		pq.offer(new Node(0, 0));
		distance[0] = 0;
		way[0] = 1;

		int mod = (int) (1e9 + 7);

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (distance[(int)curr.id] < curr.distance)
				continue;

			for (Node neighbour : this.graph.get((int)curr.id)) {
				long neighbourDistance = neighbour.distance + curr.distance;

				if (distance[(int)neighbour.id] > neighbourDistance) {
					distance[(int)neighbour.id] = neighbourDistance;
					way[(int)neighbour.id] = way[(int)curr.id];
					pq.offer(new Node(neighbour.id, neighbourDistance));
				} else if (distance[(int)neighbour.id] == neighbourDistance) {
					way[(int)neighbour.id] = (way[(int)neighbour.id] + way[(int)curr.id]) % mod;
				}
			}
		}

		this.noOfWays = way[n - 1] ;
	}

	public int getResult() {
		return this.noOfWays;
	}

}

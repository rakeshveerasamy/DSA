class Solution {
    public int makeConnected(int n, int[][] connections) {
        NetworkConnected nc = new NetworkConnected(n,connections);
        return nc.getResult();
    }
}
class Disjoinset {
	int vertices;
	List<Integer> parent;
	List<Integer> size;

	Disjoinset(int vertices) {
		this.vertices = vertices;
		this.parent = new ArrayList<>();
		this.size = new ArrayList<>();
		init();
	}

	private void init() {
		for (int i = 0; i < this.vertices; i++) {
			this.parent.add(i);
			this.size.add(1);
		}
	}

	public int findUltimateParent(int node) {
		if (node == this.parent.get(node)) {
			return node;
		}

		int parent = findUltimateParent(this.parent.get(node));
		this.parent.set(node, parent);
		return this.parent.get(node);
	}

	public void addDisjointSet(int u, int v) {
		int uParent = findUltimateParent(u);
		int vParent = findUltimateParent(v);

		if (uParent == vParent)
			return;

		if (this.size.get(uParent) < this.parent.get(vParent)) {
			this.parent.set(uParent, vParent);
			this.size.set(vParent, this.size.get(vParent) + 1);
		} else {
			this.parent.set(vParent, uParent);
			this.size.set(uParent, this.size.get(uParent) + 1);

		}
	}
}

class NetworkConnected {
	private int n;
	private int[][] connected;

	private int requiredConnection;

	NetworkConnected(int n, int[][] connected) {
		this.n = n;
		this.connected = connected;
		this.requiredConnection = -1;

		if (isValid()) {
			findPossibleConnection();
		}
	}

	private boolean isValid() {
		return this.n > 0 && this.connected != null && this.connected.length != 0 && this.connected[0].length != 0;
	}

	private void findPossibleConnection() {
		Disjoinset set = new Disjoinset(this.n);
		int extraCon = 0;
		int con = 0;

		for (int edge[] : this.connected) {
			int u = edge[0];
			int v = edge[1];

			if (set.findUltimateParent(u) == set.findUltimateParent(v)) {
				extraCon++;
			} else {
				set.addDisjointSet(u, v);
			}
		}

		for (int num = 0; num < this.n; num++) {
			if (set.parent.get(num) == num)
				con++;
		}
		int ans = con - 1;

		this.requiredConnection = (extraCon >= ans) ? ans : -1;

	}

	public int getResult() {
		return this.requiredConnection;
	}
}

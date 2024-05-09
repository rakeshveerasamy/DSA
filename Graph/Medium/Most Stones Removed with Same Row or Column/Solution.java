class Solution {
    public int removeStones(int[][] stones) {
        RemoveStone rs = new RemoveStone(stones);
        return rs.getResult();
    }
}

class DisjointSet {
	private int vertices;
	List<Integer> parent;
	List<Integer> size;

	DisjointSet(int vertices) {
		this.vertices = vertices;
		this.parent = new ArrayList<>();
		this.size = new ArrayList<>();
		init();
	}

	private void init() {
		for (int i = 0; i <= this.vertices; i++) {
			this.parent.add(i);
			this.size.add(1);
		}
	}

	public int findUltimateParent(int node) {
		if (this.parent.get(node) == node) {
			return node;
		}
		int par= findUltimateParent(this.parent.get(node));
		this.parent.set(node, par);
		return par;
	}

	public void unionBySize(int u, int v) {
		int uParent = findUltimateParent(u);
		int vParent = findUltimateParent(v);

		if (uParent == vParent)
			return;

		if (this.size.get(uParent) < this.size.get(vParent)) {
			this.parent.set(uParent, vParent);
			this.size.set(vParent, this.size.get(vParent) + this.size.get(uParent));
		} else {
			this.parent.set(vParent, uParent);
			this.size.set(uParent, this.size.get(uParent) + this.size.get(vParent));

		}

	}
}

class RemoveStone {
	private int[][] stones;
	private int removeCount;
	private int maxRow;
	private int maxCol;

	RemoveStone(int[][] stones) {
		this.stones = stones;
		this.removeCount = 0;

		if (isValid()) {
			init();
			removableStoneCount();
		}
	}

	private boolean isValid() {
		return this.stones != null && this.stones.length != 0 && this.stones[0].length == 2;
	}

	private void init() {
		int rowMax = Integer.MIN_VALUE;
		int colMax = Integer.MIN_VALUE;

		for (int num[] : this.stones) {
			rowMax = Math.max(rowMax, num[0]);
			colMax = Math.max(colMax, num[1]);
		}
		this.maxRow = rowMax;
		this.maxCol = colMax;
	}

	private void removableStoneCount() {
		int comp = 0;
		int vertices = this.maxRow + this.maxCol + 1;
		DisjointSet set = new DisjointSet(vertices);
		Map<Integer, Integer> stoneCounter = new HashMap<>();

		for (int index[] : this.stones) {
			int u = index[0];
			int v = index[1] + this.maxRow + 1;

			set.unionBySize(u, v);
			stoneCounter.put(u, 1);
			stoneCounter.put(v, 1);

		}

		for (Map.Entry<Integer, Integer> entry : stoneCounter.entrySet()) {
			if (set.findUltimateParent(entry.getKey()) == entry.getKey()) {
				comp++;
			}
		}

		this.removeCount = this.stones.length - comp;

	}

	public int getResult() {
		return this.removeCount;
	}

}

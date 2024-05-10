class SegmentTree {
	private int[] tree;
	private int[] num;
	private int height;
	private int size;
	private int n;

	SegmentTree(int[] num) {
		this.num = num;
		this.n = num.length;
		this.height = (int) Math.ceil(Math.log(n) / Math.log(2));
		this.size = (int)( 2 * Math.pow(2, this.height) - 1);
		this.tree = new int[this.size];
		buildTree(0, 0, this.n - 1);

	}

	private void buildTree(int treeIndex, int low, int high) {

		if (low == high) {
			this.tree[treeIndex] = this.num[low];
			return;
		}

		int mid = low + (high - low) / 2;
		buildTree(2 * treeIndex + 1, low, mid);
		buildTree(2 * treeIndex + 2, mid + 1, high);
		this.tree[treeIndex] = Math.min(this.tree[2 * treeIndex + 1], this.tree[2 * treeInde + 2]);

	}

	private int  query(int start, int stop) {
		return query(0, 0, this.n - 1, start, stop);
	}

private int  query(int treeIndex, int low, int high , int start, int stop){
/*1. not within range , 2. completely within range  , 3.partially within range
		*/

		if(start>high && stop<low){
			return Integer.MAX_VALUE;
		}
		if(start<=low && stop>=high){
			return this.tree[treeIndex];
		}
		int mid = low+(high-low)/2;
		
		return Math.min(query(2*treeIndex+1, low,mid,start,stop) , query(2*treeIndex+2,mid+1,high,start,stop));
}

	private void update(int index, int value) {
		update(0, 0, this.n - 1, index, value);
	}

	private void update(int treeIndex, int low, int high, int index, int value) {
		if (low == high) {
			this.tree[treeIndex] = value;
			this.num[index] = value;
			return;
		}

		int mid = low + (high - low) / 2;

		if (index <= mid) {
			update(2 * treeIndex + 1, low, mid, index, value);
		} else {
			update(2 * treeIndex + 2, mid + 1, high, index, value);
		}
		this.tree[treeIndex] = Math.min(this.tree[2 * treeIndex + 1], this.tree[2 * treeIndex + 2]);
	}
}

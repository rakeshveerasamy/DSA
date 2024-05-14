class NumArray {
    SegmentTree st;
    public NumArray(int[] nums) {
         st = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        st.update(index,val);
    }
    
    public int sumRange(int left, int right) {
        return st.query(left,right);
    }
}
class SegmentTree {
	private int nums[];
	private int size;
	private int[] tree;
	private int height;
	private int length;

	SegmentTree(int[] nums) {
		this.nums = nums;

		if (isValid()) {
			this.size = nums.length;
			this.height = (int) Math.ceil(Math.log(this.size) / Math.log(2));
			this.length = (int) (2 * Math.pow(2, this.height) - 1);
			this.tree = new int[this.length];
			buildTree(0, 0, this.size - 1);
		}
	}

	private boolean isValid() {
		return this.nums != null && this.nums.length != 0;
	}

	private void buildTree(int treeIndex, int low, int high) {
		if (low == high) {
			this.tree[treeIndex] = this.nums[low];
			return;
		}

		int mid = low + (high - low) / 2;
		buildTree(2 * treeIndex + 1, low, mid);
		buildTree(2 * treeIndex + 2, mid + 1, high);
		this.tree[treeIndex] = this.tree[2 * treeIndex + 1]+this.tree[2 * treeIndex + 2];
	}

	public int query(int start, int stop) {
		return query(0, 0, this.size - 1, start, stop);
	}

	private int query(int treeIndex, int low, int high, int start, int stop) {
		if (start > high || stop < low) {
			return 0;
		}
		if (start <= low && stop >= high) {
			return this.tree[treeIndex];
		}

		int mid = low + (high - low) / 2;

		return query(2 * treeIndex + 1, low, mid, start, stop)+query(2 * treeIndex + 2, mid + 1, high, start, stop);

	}

	public  void update(int index, int num) {
		update(0, 0, this.size - 1, index, num);
	}

	private void update(int treeIndex, int low, int high, int index, int num) {
		if (low == high) {
			this.tree[treeIndex] = num;
			this.nums[index] = num;
			return;
		}
		int mid = low + (high - low) / 2;

		if (index <= mid) {
			update(2 * treeIndex + 1, low, mid, index, num);
		} else {
			update(2 * treeIndex + 2, mid + 1, high, index, num);
		}
		this.tree[treeIndex] = this.tree[2 * treeIndex + 1]+this.tree[2 * treeIndex + 2];
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

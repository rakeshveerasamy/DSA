class Solution {
    public int largestRectangleArea(int[] heights) {
        MaximumRectangle mr = new MaximumRectangle(heights);
        return mr.getResult();
    }
}
class MaximumRectangle {
	private int [] heights;
	private int row;
	private int maxArea;

	MaximumRectangle(int [] heights) {
		this.heights = heights;
		this.maxArea = 0;

		if (isValid()) {
			this.row = heights.length;
			findMaxRectangle();
		}
	}

	private boolean isValid() {
		return this.heights != null && this.heights.length != 0 ;
	}

	private void findMaxRectangle() {
		int size = this.heights.length;
		int[] leftSmallest = findPrevSmallest();
		int[] rightSmallest = findNextSmallest();

		for (int i = 0; i < size; i++) {
			this.maxArea = Math.max(this.maxArea, (this.heights[i] * (rightSmallest[i] - leftSmallest[i] + 1)));
		}

	}

	private int[] findPrevSmallest() {
		int size = this.heights.length;
		int[] ans = new int[size];
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < size; i++) {
			while (!stk.isEmpty() && this.heights[stk.peek()] >= this.heights[i]) {
				stk.pop();
			}

			if (stk.isEmpty())
				ans[i] = 0;
			else
				ans[i] = stk.peek() + 1;
			stk.push(i);
		}

		return ans;
	}

	private int[] findNextSmallest() {
		int size = this.heights.length;
		int[] ans = new int[size];
		Stack<Integer> stk = new Stack<>();

		for (int i = size - 1; i >= 0; i--) {
			while (!stk.isEmpty() && this.heights[stk.peek()] >= this.heights[i]) {
				stk.pop();
			}

			if (stk.isEmpty())
				ans[i] = size - 1;
			else
				ans[i] = stk.peek() - 1;
			stk.push(i);
		}

		return ans;
	}

	public int getResult() {
		return this.maxArea;
	}

}

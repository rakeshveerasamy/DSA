class Solution {
    public int maximalRectangle(char[][] matrix) {
        MaximumRectangle mr =new MaximumRectangle(matrix);
        return mr.getResult();
    }
}

class MaximumRectangle {
	private char[][] matrix;
	private int row;
	private int col;
	private int maxArea;

	MaximumRectangle(char[][] matrix) {
		this.matrix = matrix;
		this.maxArea = 0;

		if (isValid()) {
			this.row = matrix.length;
			this.col = matrix[0].length;
			findLargestRectangle();
		}
	}

	private boolean isValid() {
		return this.matrix != null && this.matrix.length != 0 && this.matrix[0].length != 0;
	}

	private void findLargestRectangle() {
		int[] histo = new int[this.col];
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				if (this.matrix[i][j] == '1')
					histo[j]++;
				else
					histo[j] = 0;
			}
			maxArea = Math.max(maxArea, findMaxRectangle(histo));
		}

		this.maxArea = maxArea;
	}

	private int findMaxRectangle(int[] height) {
		int size = height.length;
		int[] leftSmallest = findPrevSmallest(height);
		int[] rightSmallest = findNextSmallest(height);

		int maxArea = 0;
		for (int i = 0; i < size; i++) {
			maxArea = Math.max(maxArea, (height[i] * (rightSmallest[i] - leftSmallest[i] + 1)));
		}
		return maxArea;

	}

	private int[] findPrevSmallest(int[] height) {
		int size = height.length;
		int[] ans = new int[size];
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < size; i++) {
			while (!stk.isEmpty() && height[stk.peek()] >= height[i]) {
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

	private int[] findNextSmallest(int[] height) {
		int size = height.length;
		int[] ans = new int[size];
		Stack<Integer> stk = new Stack<>();

		for (int i = size - 1; i >= 0; i--) {
			while (!stk.isEmpty() && height[stk.peek()] >= height[i]) {
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

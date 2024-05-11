class Solution {
    public int countSquares(int[][] matrix) {
        CountSquare cs = new CountSquare(matrix);
        return cs.getResult();
    }
}
class CountSquare {
	private int[][] matrix;
	private int row;
	private int col;
	private int count;

	CountSquare(int[][] matrix) {
		this.matrix = matrix;
		this.count = 0;

		if (isValid()) {
			this.row = matrix.length;
			this.col = matrix[0].length;
			countSquares();
		}
	}

	private boolean isValid() {
		return this.matrix != null && this.matrix.length != 0 && this.matrix[0].length != 0;
	}

	private void countSquares() {
		int[][] counter = new int[this.row][this.col];

		for (int i = 0; i < this.row; i++) {
			counter[i][0] = matrix[i][0];
		}

		for (int i = 0; i < this.col; i++) {
			counter[0][i] = matrix[0][i];
		}

		for (int i = 1; i < this.row; i++) {
			for (int j = 1; j < this.col; j++) {
                if(this.matrix[i][j] ==1)
				counter[i][j] = Math.min(counter[i - 1][j - 1], Math.min(counter[i - 1][j], counter[i][j - 1]))+1;
			}
		}

         int sum = 0;
        for(int[] num: counter){
            for(int value:num){
                sum+=value;
            }
        }
		this.count = sum;
	}

	public int getResult() {
		return this.count;
	}
}

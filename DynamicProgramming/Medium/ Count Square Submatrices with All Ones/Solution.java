class Solution {
    public int countSquares(int[][] matrix) {
        CountSquare cs = new CountSquare(matrix);
        return cs.getResult();
    }
}
class CountSquare {
    private int[][] mat;
    private int row;
    private int col;
    private int count;

    CountSquare(int[][] mat) {
        this.mat = mat;
        this.count = 0;

        if (isValid()) {
            this.row = mat.length;
            this.col = mat[0].length;
            findSquareCount();
        }
    }

    private boolean isValid() {
        return this.mat != null && this.mat.length != 0 && this.mat[0].length != 0;
    }

    private void findSquareCount() {
        int[][] dp = new int[this.row][this.col];

        for (int i = 0; i < row; i++) {
            if (this.mat[i][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < col; i++) {
            if (this.mat[0][i] == 1) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (this.mat[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for(int j=0;j<this.col;j++){
                this.count+=dp[i][j];
            }
        }
    }

    public int getResult() {
        return this.count;
    }
}

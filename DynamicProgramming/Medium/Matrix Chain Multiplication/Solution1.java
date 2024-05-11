import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
		MatrixChainMultiplication mcm = new MatrixChainMultiplication(arr);
		return mcm.getResult();
	}
}
class MatrixChainMultiplication {
	private int[] arr;
	private int N;
	private int minMultiply;

	MatrixChainMultiplication(int[] arr) {
		this.arr = arr;
		this.minMultiply = 0;

		if (isValid()) {
			this.N = arr.length;
			findMinimumMultiplication();
		}
	}

	private boolean isValid() {
		return this.arr != null && this.arr.length > 1;
	}

	private void findMinimumMultiplication() {
		int[][] dp = new int[this.N][this.N];

		for (int i = 0; i < this.N; i++) {
			dp[i][i] = 0;
		}

		for (int i = this.N - 1; i >= 1; i--) {
			for (int j = i + 1; j < N; j++) {
				int minMultiply = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					minMultiply = Math.min(minMultiply,dp[i][k] + dp[k + 1][j] + (this.arr[i - 1] * this.arr[k] * this.arr[j]));

				}
				dp[i][j] = minMultiply;
			}
		}

		this.minMultiply = dp[1][this.N-1];
	}

	public int getResult() {
		return this.minMultiply;
	}
}


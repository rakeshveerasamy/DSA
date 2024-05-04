class Solution {
    public int uniquePaths(int m, int n) {
        PathSum ps= new PathSum(m,n);
        return ps.getResult();
    }
}
class PathSum {
	private int m;
	private int n;
	private int res;
	private int[] dp;

	PathSum(int m, int n) {
		this.m = m;
		this.n = n;
		this.res = 1;

		if (isValid()) {
			this.dp = new int[this.n];
			findPathSum();
		}
	}

	private boolean isValid() {
		return this.m >1 && this.n > 1  ;
	}

	private void findPathSum() {
		this.dp[0] = 1;
		for (int i = 0; i < this.m; i++) {
			for (int j = 1; j < this.n; j++) {
				 this.dp[j]+=this.dp[j-1];
			}
		}
		this.res = this.dp[this.n-1];
	}

	public int getResult() {
		return this.res;
	}

}

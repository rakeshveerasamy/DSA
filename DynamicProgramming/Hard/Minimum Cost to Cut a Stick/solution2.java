class Solution {
    public int minCost(int n, int[] cuts) {
        MinCost mc = new MinCost(cuts,n);
        return mc.getResult();
    }
}
class MinCost {
	private int[] cost;
	private int n;
	private int minCost;

	MinCost(int[] cost, int n) {
		this.cost = cost;
		this.n = n;
		this.minCost = 0;

		if (isValid()) {
			findMinCost();
		}
	}

	private boolean isValid() {
		return this.cost != null && this.cost.length != 0 && this.n != 0 && this.cost.length < this.n;
	}

	private void findMinCost() {
		List<Integer> costList = new ArrayList<>();
		costList.add(0);
		costList.add(this.n);

		for (int num : this.cost) {
			costList.add(num);
		}
        Collections.sort(costList);
        int size = this.cost.length;
        
        int [][] dp =new int [size+2][size+2];
            
        for(int i=0;i<size+2;i++){
                Arrays.fill(dp[i],-1);
        }
		this.minCost = findMinCostHelper(1, this.cost.length, costList,dp);
	}

	private int findMinCostHelper(int i, int j, List<Integer> costList,int [][] dp) {
		if (i > j)
			return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j; k++) {
			int ans = (costList.get(j + 1) - costList.get(i - 1)) + findMinCostHelper(i, k - 1, costList,dp) + findMinCostHelper(k + 1, j, costList,dp);
			min = Math.min(min, ans);
		}
		return dp[i][j] = min;
	}

	public int getResult() {
		return this.minCost;
	}

}

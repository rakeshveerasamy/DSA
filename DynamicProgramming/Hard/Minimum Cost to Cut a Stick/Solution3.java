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
                Arrays.fill(dp[i],0);
        }
        
        for(int i=size;i>=1;i--){
            for(int j = 1;j<=size;j++){
                if(i>j){
                   continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k = i;k<=j;k++){
                       int ans = (costList.get(j+1)-costList.get(i-1)) + dp[i][k-1]+dp[k+1][j];
                        min = Math.min(min,ans);
                }
                dp[i][j] = min;
            }
        }
        this.minCost = dp[1][size];
	}

	

	public int getResult() {
		return this.minCost;
	}

}

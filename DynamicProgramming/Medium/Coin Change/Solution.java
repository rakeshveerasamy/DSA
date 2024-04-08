class Solution {
    public int coinChange(int[] coins, int amount) {
        CoinChange cc=new CoinChange(coins,amount);
        return cc.getResult();
    }
}
class CoinChange{
    private int [] coins;
    private int dp[];
    private int amount;

    CoinChange(int [] coins,int amount){
        this.coins=coins;
        this.amount = amount;
        this.dp =  new int[this.amount+1];
        init();
    }	

    private void init(){
        Arrays.fill(this.dp,this.amount+1);
        this.dp[0] = 0;
        findMinCoin();
	}
	private void findMinCoin(){
		for(int i = 1;i<=this.amount;i++){
			for(int coin:this.coins){
				if(coin<=i){
					this.dp[i] = Math.min(this.dp[i],this.dp[i-coin]+1);
				}
			}
		}
	}
	public int getResult(){
		return (this.dp[this.amount]>this.amount)?-1:this.dp[this.amount];
	}

}

class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int [][] dp = new int [size+1][2];

        dp[size][0] = 0;
        dp[size][1]  = 0;

        for(int index=size-1;index>=0;index--){
            for(int buy = 0;buy<=1;buy++ ){
                int profit = Integer.MIN_VALUE;

                if(buy==1){
                    profit = Math.max(-prices[index]+dp[index+1][0],0+dp[index+1][1]);
                }
                else{
                    profit = Math.max(prices[index]+dp[index+1][1],0+dp[index+1][0]);
                }
                dp[index][buy]=  profit;
            }
        }

        return dp[0][1];
    }


}

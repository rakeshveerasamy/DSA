class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int [][][] dp = new int [size+1][2][3];


        for(int index=size-1;index>=0;index--){
            for(int buy = 0;buy<=1;buy++){
                for(int transaction =1;transaction<=2;transaction++){

                    int profit =0;
                    if(buy == 1){
                        profit = Math.max(-prices[index]+dp[index+1][0][transaction],
                                    0+dp[index+1][1][transaction]);
                    }
                    else{
                        profit = Math.max(prices[index]+dp[index+1][1][transaction-1],
                                    0+dp[index+1][0][transaction]);
                    }
                    dp[index][buy][transaction] =  profit;
                }
            }
        }

        return dp[0][1][2];
    }
}

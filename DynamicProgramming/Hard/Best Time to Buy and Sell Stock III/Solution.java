class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitHelper(0,1,0,prices);
    }

    private int maxProfitHelper(int index , int buy, int transaction,int[] prices){
        if(index == prices.length  || transaction == 2){
            return 0;
        }
        int profit =0;
        if(buy == 1){
            profit = Math.max(-prices[index]+maxProfitHelper(index+1,0,transaction,prices),
                        0+maxProfitHelper(index+1,1,transaction,prices));
        }
        else{
            profit = Math.max(prices[index]+maxProfitHelper(index+1,1,transaction+1,prices),
                        0+maxProfitHelper(index+1,0,transaction,prices));
        }
        return profit;
    }
}

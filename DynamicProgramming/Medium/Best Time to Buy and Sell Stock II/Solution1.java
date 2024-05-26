class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitHelper(0,1,prices);
    }
    private int maxProfitHelper(int index, int buy,int [] prices){
        if(index == prices.length){
            return 0;
        }
        int profit = Integer.MIN_VALUE;

        if(buy==1){
            profit = Math.max(-prices[index]+maxProfitHelper(index+1,0,prices),0+maxProfitHelper(index+1,1,prices));
        }
        else{
            profit = Math.max(prices[index]+maxProfitHelper(index+1,1,prices),0+maxProfitHelper(index+1,0,prices));
        }
        return profit;
    }
}

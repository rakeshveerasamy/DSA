//Time Complexity -  O(n)
//Space Complexity - O(1)

class Solution {
    public int maxProfit(int[] prices) {
        BuyStock buy = new BuyStock(prices);
        return buy.maxProfit();
    }
}
class BuyStock{
    int [] prices;

    BuyStock(int [] prices){
        this.prices = prices;
    }

    public  int maxProfit(){

        int minToBuy = Integer.MAX_VALUE;
        int maxDiff = 0;

        for(int i = 0;i<this.prices.length;i++){
            minToBuy = Math.min(minToBuy, this.prices[i]);
            maxDiff = Math.max(maxDiff,(this.prices[i] - minToBuy));
        }
        return maxDiff;
    }
}

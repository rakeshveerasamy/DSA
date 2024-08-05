class Solution {
    public int rob(int[] nums) {
        HouseRobber hr = new HouseRobber(nums);
        return hr.getResult();
    }
}
 class HouseRobber{
    private int nums[];
    private int length;
    private int maxAmount;

    HouseRobber(int [] nums ){
        this.nums = nums;
        this.maxAmount = 0;

        if(isValid()){
            this.length = this.nums.length;
            findMaxAmount();
        }
    }

    private boolean isValid(){
        return this.nums!=null && this.nums.length!=0;
    }

    private void findMaxAmount(){
        if(this.length == 1){
            this.maxAmount = this.nums[0];
            return;
        }
        int [] dp = new int [this.length];
        dp[0] = this.nums[0];
        dp[1] = Math.max(this.nums[0],this.nums[1]);

        for(int i=2;i<this.length;i++){
            int pick = this.nums[i]+dp[i-2];
            int not_pick = dp[i-1];

            dp[i] = Math.max(pick,not_pick);
        }

        this.maxAmount = dp[this.length-1];
    }

    public int getResult(){
        return this.maxAmount;
    }
 }

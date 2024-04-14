class Solution {
    public boolean canPartition(int[] nums) {
        PartitionSum ps =new PartitionSum(nums);
        return ps.canPartition();
    }
}

class PartitionSum{
        private int [] nums;
        private int size;
        
        PartitionSum(int[] nums){
           this.nums= nums;
            this.size =nums.length;
        }
        public boolean canPartition(){
            int totalSum = 0;
            for(int num:nums){
                totalSum+=num;
            }
            if(totalSum%2 == 1){
                return false;
            }
            int target = totalSum/2;
            boolean [] dp = new boolean [target+1];
            dp[0] = true;
            for(int num:nums){
                for(int j =target ;j>=num;j--){
                    dp[j] = dp[j] || dp[j-num];
                }
            }
            return dp[target];
        }
}

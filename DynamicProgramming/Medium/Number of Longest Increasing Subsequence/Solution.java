class Solution {
    public int findNumberOfLIS(int[] nums) {
        NumberofLIS lis =new NumberofLIS(nums);
        return lis.getResult();
    }
}

class NumberofLIS{
        private int [] nums;
        private int size;
        private int count;
        
        NumberofLIS(int [] nums){
            this.nums =nums;
            this.count =0;
                
            if(isValid()){
                 this.size =nums.length;
                findNumberOfLIS();
            }
            
        }
    
        private boolean isValid(){
                return this.nums!=null && this.nums.length!=0;
        }
        
        private void findNumberOfLIS(){
                
            int [] dp = new int [this.size];
            int [] count =new int[this.size];
            
            Arrays.fill(dp,1);
            Arrays.fill(count,1);
            
            int max = Integer.MIN_VALUE;
            
            
            for(int index =0;index<this.size;index++){
                for(int prev_index =0;prev_index<=index-1;prev_index++){
                    
                    if((this.nums[index]>this.nums[prev_index] && 1+dp[prev_index]>dp[index])){
                        dp[index] = 1+dp[prev_index];
                        count[index] = count[prev_index];
                    }
                    else if ((this.nums[index]>=this.nums[prev_index] && 1+dp[prev_index]==dp[index])){
                        count[index]+=count[prev_index];
                    }
                }
                
                max = Math.max(max,dp[index]);
            }
             for(int i=0;i<this.size;i++){
                if(dp[i] == max){
                    this.count+=count[i];
                }
            }
        }
    
       
            
        public int getResult(){
            return this.count;
        }
}

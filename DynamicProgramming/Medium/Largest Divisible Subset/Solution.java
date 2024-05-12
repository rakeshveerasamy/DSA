class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LargestDivisibleSubset lds = new LargestDivisibleSubset(nums);
        return lds.getResult();
    }
}

class LargestDivisibleSubset{
        private int [] nums;
        private int size;
        private List<Integer> res;
        
        LargestDivisibleSubset(int [] nums){
            this.nums =nums;
            this.res = new ArrayList<>();
                
            if(isValid()){
                    this.size =nums.length;
                    findLargestSubset();
            }
        }
    
        private boolean isValid(){
                return this.nums!=null && this.nums.length!=0;
        }
    
        private void findLargestSubset(){
                Arrays.sort(this.nums);
                
                int [] dp = new int [this.size];
                int [] hash =new int [this.size];
            
                Arrays.fill(dp,1);
                Arrays.fill(hash,0);
            
                int max = Integer.MIN_VALUE;
                int last_index = 0;
            
            
                for(int i= 0;i<this.size;i++){
                    hash[i] = i;
                    for(int j = 0;j<=i-1;j++){
                            if((this.nums[i]%this.nums[j] == 0)  && dp[j]+1>dp[i]){
                                dp[i] = 1+dp[j];
                                hash[i] = j;
                            }
                    }
                    if(dp[i]>max){
                        max = dp[i];
                        last_index = i;
                    }
                        
                }
                while(hash[last_index]!=last_index){
                    this.res.add(this.nums[last_index]);
                    last_index = hash[last_index];
                }
                this.res.add(this.nums[last_index]);

                
            
        }
    
        public List<Integer> getResult(){
            return this.res;
        }
}

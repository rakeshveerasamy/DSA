class Solution {
    public int maxCoins(int[] nums) {
        BurstBallon bb  = new BurstBallon(nums);
        return bb.getResult();
    }
}
class BurstBallon{
    private int [] nums;
    private int size;
    private int maxCoin;
    
    BurstBallon(int [] nums){
        this.nums = nums;
        this.maxCoin = 0;
            
        if(isValid()){
            this.size = nums.length;
            findMaxCoin();
        }
    }
    
    private boolean isValid(){
            return this.nums!=null && this.nums.length!=0;
    }
    
    private void findMaxCoin(){
            
        List<Integer> numList = new ArrayList<>();
        for(int value:this.nums){
            numList.add(value);
        }
        numList.add(1);
        numList.add(0,1);
        
        int [][] dp = new int [this.size+2][this.size+2];
        
        for(int i=0;i<this.size+2;i++){
            Arrays.fill(dp[i],0);
        }
       
        for(int i =this.size;i>=1;i--){
            for(int j = 1;j<=this.size;j++){
                if(i>j){
                    continue;
                }
                
                int max = Integer.MIN_VALUE;
                
                for(int ind =i;ind<=j;ind++){
                    int ans = (numList.get(i-1)*numList.get(ind)*numList.get(j+1))+dp[i][ind-1]+dp[ind+1][j];
                    max = Math.max(max,ans);
                }
                dp[i][j] =max;
            }
        }
        
        this.maxCoin = dp[1][this.size];
    }
    

    public int getResult(){
            return this.maxCoin;
    }
}

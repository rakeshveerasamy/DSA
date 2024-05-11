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
            Arrays.fill(dp[i],-1);
        }
        
        this.maxCoin = findMaxCoinHelper(1,this.size,numList,dp);
    }
    
    private int findMaxCoinHelper(int i,int j,List<Integer> numList,int [][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int k = i;k<=j;k++){
                
            int ans = (numList.get(i-1)*numList.get(k)*numList.get(j+1))+findMaxCoinHelper(i,k-1,numList,dp)+findMaxCoinHelper(k+1,j,numList,dp);
            max = Math.max(max,ans);
        }
        return dp[i][j] =  max;
    }
    public int getResult(){
            return this.maxCoin;
    }
}

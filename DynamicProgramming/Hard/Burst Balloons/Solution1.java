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
        
        this.maxCoin = findMaxCoinHelper(1,this.size,numList);
    }
    
    private int findMaxCoinHelper(int i,int j,List<Integer> numList){
        if(i>j){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int k = i;k<=j;k++){
                
            int ans = (numList.get(i-1)*numList.get(k)*numList.get(j+1))+findMaxCoinHelper(i,k-1,numList)+findMaxCoinHelper(k+1,j,numList);
            max = Math.max(max,ans);
        }
        return max;
    }
    public int getResult(){
            return this.maxCoin;
    }
}

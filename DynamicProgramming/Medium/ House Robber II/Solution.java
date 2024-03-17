class Solution {
    public int rob(int[] nums) {
        
        if(nums == null) return 0;
        int len= nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        
        int max1 = maxRob(nums , 0, len-2);
        int max2 = maxRob(nums , 1, len-1);
        return Math.max(max1,max2);
    }
    public int maxRob(int [] nums , int start , int stop){
        int maxAmount = 0;
        int firstPrev = nums[start];
        int secondPrev = maxAmount =  Math.max(firstPrev,nums[start+1]);
        for(int i = start+2;i<=stop;i++){
            maxAmount = Math.max(nums[i] +firstPrev, secondPrev);
            firstPrev = secondPrev;
            secondPrev = maxAmount;
        }
        return maxAmount;
    }
    
}

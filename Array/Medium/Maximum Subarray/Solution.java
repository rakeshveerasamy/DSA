class Solution {
    public int maxSubArray(int[] nums) {
        MaxSubArray max = new  MaxSubArray(nums);
        return max.getMaxSubArray();
    }
}

class MaxSubArray{
    private int[] nums;
    private int length;
    MaxSubArray(int [] nums){
        this.nums = nums;
        this.length = nums.length;
    }
    public int getMaxSubArray(){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = -1;
        for(int i = 0;i<this.length;i++){
            maxEndingHere = Math.max(maxEndingHere+this.nums[i],this.nums[i]);
            maxSoFar = Math.max(maxEndingHere ,maxSoFar);
            if(maxEndingHere<0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}

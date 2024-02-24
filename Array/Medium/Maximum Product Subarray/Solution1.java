class Solution {
    public int maxProduct(int[] nums) {
        MaxProduct mx =  new MaxProduct(nums);
        return mx.maxProductSubArray();
    }
}
class MaxProduct{
        private int[] nums;
        MaxProduct(int [] nums){
            this.nums = nums;
        }
        public int maxProductSubArray(){
           int maxEndingHere = this.nums[0];
           int minEndingHere = this.nums[0];
           int maxSoFar = this.nums[0];
            for(int i = 1;i<this.nums.length;i++){   
                int temp= maxEndingHere;
                maxEndingHere = Math.max(this.nums[i],Math.max(maxEndingHere*this.nums[i] , minEndingHere*this.nums[i]));
                minEndingHere = Math.min(this.nums[i],Math.min(temp*this.nums[i],this.nums[i]*minEndingHere));
                maxSoFar = Math.max(maxSoFar,maxEndingHere);
            }
            return maxSoFar;
        }
}

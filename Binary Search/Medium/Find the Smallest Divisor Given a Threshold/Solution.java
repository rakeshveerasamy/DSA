class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low<high){
            int mid = low+(high-low)/2;
            if(canDivide(nums , mid, threshold)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean canDivide(int[] nums , int divisor, int threshold){
        int sum = 0;
        for(int num:nums){
            sum+=(num+divisor-1)/divisor;
        }
        return sum<=threshold;
    }
    
}

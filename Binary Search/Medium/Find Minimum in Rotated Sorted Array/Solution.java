class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int size = nums.length;
        int high = size-1;
        int res = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return Math.min(res,nums[low]);
            }
            else if (nums[mid]<=nums[high]){
                res = Math.min(res,nums[mid]);
                high = mid-1;
            }
            else {
                res = Math.min(res,nums[low]);
                low = mid+1;
            }
                                     
        }
        return res;
    }
}

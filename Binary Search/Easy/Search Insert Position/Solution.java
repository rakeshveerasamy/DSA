class Solution {
    public int searchInsert(int[] nums, int target) {
         int insertIndex = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
                int mid = low+(high -low)/2;
                if(nums[mid] == target ) return mid;
                else if(nums[mid]>target){
                        insertIndex = mid;
                        high = mid-1;
                }
                else low = mid+1;
        }
        return insertIndex;
    }
}

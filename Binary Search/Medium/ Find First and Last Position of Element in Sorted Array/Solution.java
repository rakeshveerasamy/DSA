class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int [] {-1,-1};
        
        int first = findFirstPosition(nums, target);
        if(first!=-1){
            int last = findLastPosition(nums, target);
            res[0] = first;
            res[1] = last;
        }
        return res;
        
    }
    private int findFirstPosition(int [] nums , int target){
        int firstIndex = -1;
        int low =0;
        int high = nums.length-1;
        while(low<=high){
                int mid =low+(high-low)/2;
                if(nums[mid]>=target){
                    if(nums[mid] == target) firstIndex = mid;
                    high = mid-1;
                }
                else low = mid+1;
        }
        return firstIndex;
    }
    private int findLastPosition(int [] nums , int target){
        int lastindex = -1;
        int low =0;
        int high = nums.length-1;
        while(low<=high){
                int mid =low+(high-low)/2;
                if(nums[mid]<=target){
                    if(nums[mid] == target) lastindex = mid;
                    low = mid+1;
                }
                else high = mid-1;
        }
        return lastindex;
    }
}

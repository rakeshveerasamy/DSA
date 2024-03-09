class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int size = nums.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mid%2 == 1){
                mid--;
            }
            if( nums[mid] != nums[mid+1]){
                high= mid-1;
            }
            else{
                low = mid+2;
            }
        }
        return nums[low];
    }
}

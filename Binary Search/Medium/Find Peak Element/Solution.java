class Solution {
    public int findPeakElement(int[] nums) {
        PeakElement pe = new PeakElement(nums);
        return pe.find();
    }
}

class PeakElement{
    private int[] nums;

    PeakElement(int[] nums){
        this.nums= nums;
    }

    public int find(){
        int left = 0;
        int right = this.nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;

            if(this.nums[mid] > this.nums[mid+1]){
                right = mid;
            }

            else{
                left = mid+1;
            }
        }
        return left;
    }
}

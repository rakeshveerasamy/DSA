class Solution {
    public void nextPermutation(int[] nums) {
        NextPermutation np = new NextPermutation(nums);
        nums = np.generateNextPermutation();
    }
}
class NextPermutation{
    private int[] nums;
    
    NextPermutation(int [] nums){
        this.nums = nums;
    }
    
    public int[] generateNextPermutation(){
        if(this.nums == null || this.nums.length <1){
            return this.nums;
        }
        int pivotIndex = -1;
        for(int i = this.nums.length -2 ;i>=0;i--){
            if(this.nums[i]<this.nums[i+1]){
                pivotIndex = i;
                break;
            }
        }
        if(pivotIndex !=-1){
            int smallestIndex = -1;
            for(int i = this.nums.length-1;i>pivotIndex;i--){
                if(this.nums[i]>this.nums[pivotIndex]){
                    smallestIndex = i;
                    break;
                }
            }
            swap(pivotIndex,smallestIndex);
        }
        reverse(pivotIndex+1,this.nums.length-1);
        return this.nums;
        
    }
    
    private void swap(int start, int stop){
        int temp = this.nums[start];
        this.nums[start] = this.nums[stop];
        this.nums[stop] = temp;
    }
    
    private void reverse(int start, int stop){
            while(start<stop){
                swap(start,stop);
                start++;
                stop--;
            }
    }
    
}

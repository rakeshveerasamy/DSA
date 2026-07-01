class Solution {
    public void nextPermutation(int[] nums) {
        NextPermutation np = new NextPermutation(nums);
        nums = np.getResult();
    }
}

class NextPermutation{
    private int []  nums;

    NextPermutation(int [] nums){
        this.nums = nums;
    }

    private void findNextPermutation(){
            if(!isValid()){
                return;
            }

            int pivotIndex = -1;

            int len = this.nums.length;

            for(int i=len-2;i>=0;i--){
                if(this.nums[i]<this.nums[i+1]){
                    pivotIndex = i;
                    break;
                }

            }

            if(pivotIndex!=-1){
                int secondPivot = -1;
                for(int i = len-1;i>pivotIndex;i--){
                    if(this.nums[i]>this.nums[pivotIndex]){
                        secondPivot = i;
                        break;
                    }
                }

                if(secondPivot!=-1){
                    this.swap(pivotIndex, secondPivot);
                }
            }

            this.reverse(pivotIndex+1, len-1);
    }

    private void swap(int i, int j){
        int temp = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = temp;
    }

    private void reverse(int start, int stop){
        while(start<stop){
            this.swap(start, stop);
            start++;
            stop--;
        }
    }

    private boolean isValid(){
        return this.nums!=null && this.nums.length>0;
    }
    public int[] getResult(){
        this.findNextPermutation();
        return this.nums;
    }
}

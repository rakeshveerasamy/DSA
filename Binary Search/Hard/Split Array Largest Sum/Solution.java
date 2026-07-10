class Solution {
    public int splitArray(int[] nums, int k) {
        ArraySplit as = new ArraySplit(nums, k);
        return as.getResult();
    }
}

class ArraySplit{
    private int [] nums;
    private int k;

    ArraySplit(int [] nums, int k){
        this.nums = nums;
        this.k = k;
    }

    private boolean isSplitPossible(int maxSum){
        int count  = 1;
        int sum = 0;

        for(int num: this.nums){
            if((sum+num)<= maxSum){
                sum+=num;
            }
            else{
                count++;
                sum = num;
            }
        }

        return (count<= this.k);
    }

    private int findLargestSum(){
        if(!isValid()){
            return -1;
        }

        int low = 0;
        int high = 0;

        for(int num: this.nums){
            low = Math.max(num, low);
            high += num;
        }

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isSplitPossible(mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
    private boolean isValid(){
        return this.nums!=null && this.nums.length>0;
    }

    public int getResult(){
        return this.findLargestSum();
    }
}

// Time Complexity =  O(n)
//SPace complexity = O(1)

class MaxSubArray{
    private int[] arr;

    MaxSubArray(int[] arr){
        this.arr = arr;
    }

    public int findMax(){
        if(!isValid()){
            return -1;
        }

        int currentSum = this.arr[0];
        int maxSum = this.arr[0];

        for(int i=1;i<this.arr.length;i++){

            currentSum = Math.max(this.arr[i] ,  currentSum+this.arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private boolean isValid(){
        return this.arr!=null && this.arr.length>0;
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
            RotateArray rotateArray = new RotateArray (nums);
            rotateArray.rotate(k);
            nums = rotateArray.finalResult();
        
    }
}

class RotateArray{
    private int[] arr;
    
    RotateArray(int[] arr){
            this.arr = arr;
    }   

    public void rotate (int k){

            if(!isValid()){
                    return;
            }

            k = k%this.arr.length;
            rotate(0,this.arr.length-1);
            rotate(0,k-1);
            rotate(k,this.arr.length-1);
    }

    private boolean isValid(){
            return this.arr!=null && this.arr.length>0;
    }

    private void rotate(int low , int high){
            for(int i = low, j= high; i<j;i++,j--){
                int temp = this.arr[i];
                this.arr[i] = this.arr[j];
                this.arr[j] = temp;
            }
    }

    public int[] finalResult(){
            return this.arr;
    }
}

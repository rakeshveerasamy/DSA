// Time Complexity = O(n)
//Space Complexity = O(1)

class SortColors{
    private int[] arr;
    SortColors(int[] arr){
        this.arr = arr;
    }

    public void sort(){
            if(!isValid()){
                return;
            }

            int left = 0,right = this.arr.length-1,i=0;

            while(i<=right){
                if(this.arr[i] == 0){
                    swap(i,left);
                    i++;
                    left++;
                }
                else if (this.arr[i] ==2){
                    swap(i,right);
                    right--;
                }
                else{
                    i++;
                }
            }
    }

    private boolean isValid(){
        return this.arr!=null && this.arr.length>0;
    }

    private void swap(int i, int j){
        int temp = this.arr[i];
        this.arr[i] =this.arr[j];
        this.arr[j] = temp;
    }

    public int[] getResult(){
        return this.arr;
    }
}

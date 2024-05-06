class Solution {
    public void sortColors(int[] nums) {
        SortArray sa= new SortArray(nums);
        nums = sa.getResult();
    }
}
class SortArray {
    int[] arr;
    int size;

    SortArray(int[] arr) {
        this.arr = arr;

        if (isValid()) {
            this.size = arr.length;
            sortColor();
        }
    }

    private boolean isValid() {
        return this.arr != null && this.arr.length != 0;
    }

    private void sortColor() {
        int i = 0;
        int left = 0;
        int right = this.size - 1;

        while (i <= right) {
            if (this.arr[i] == 0) {
                swap(i, left);
                i++;
                left++;
            } else if (this.arr[i] == 2) {
                swap(i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }
    
    public int[] getResult(){
        return this.arr;
    }
}

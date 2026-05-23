// Time complexity = O(n^2)
// Space complexity  = O(1)
//Not a stable sort 

class SelectionSort {
    private int[] arr;

    SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        if (!isValid()) {
            return;
        }

        for (int i = 0; i < this.arr.length - 1; i++) {
            int minIndx = i;

            for (int j = i; j < this.arr.length; j++) {
                if (this.arr[j] < this.arr[minIndx]) {
                    minIndx = j;
                }
            }

            if (minIndx != i) {
                swap(minIndx, i);
            }
        }
    }

    private boolean isValid() {
        return this.arr != null && this.arr.length > 0;
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    public void print(){
		for(int ele : this.arr){
			System.out.print(ele+" ");
		}
	}
}

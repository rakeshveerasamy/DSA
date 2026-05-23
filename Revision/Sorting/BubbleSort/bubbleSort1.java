//Time Complexity = O(n^2)
//Space Complexity = O(1)

//Stable Sort


class BubbleSort {
    private int[] arr;

    BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private boolean isValid() {

        return this.arr != null && this.arr.length > 0;
    }

    public void sort() {
        if (!isValid()) {
            return;
        }

        for (int i = this.arr.length - 1; i >= 1; i--) {
            boolean swap = false;
            for (int j = 0; j <= i-1; j++) {
                if (this.arr[j] > this.arr[j + 1]) {
                    swap(j, j + 1);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    public void print() {
        for (int ele : this.arr) {
            System.out.print(ele + " ");
        }
    }
}

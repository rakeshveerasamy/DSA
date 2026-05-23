//Time Complexity : O(n^2)
//Space complexity : O(1)
//Stable sort


class InsertionSort {
    private int[] arr;

    InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        if (!isValid()) {
            return;
        }

        for (int i = 1; i < this.arr.length; i++) {
            int current = this.arr[i];
            int j = i - 1;
            while (j >= 0 && this.arr[j] > current) {
                this.arr[j + 1] = this.arr[j];
                j--;
            }

            this.arr[j + 1] = current;
        }
    }

    private boolean isValid() {
        return this.arr != null && this.arr.length > 0;
    }

    public void print() {
        for (int ele : this.arr) {
            System.out.print(ele + " ");
        }
    }
}

class QuickSort {

    private int[] arr;

    QuickSort(int[] arr) {
        this.arr = arr;
    }

    private boolean isValid() {
        return this.arr != null && this.arr.length > 1;
    }

    public void sort() {

        if (!isValid()) {
            return;
        }

        quickSort(0, this.arr.length - 1);
    }

    private void quickSort(int low, int high) {

        if (low >= high) {
            return;
        }

        int pivot = this.arr[low];

        int start = low;
        int stop = high;

        while (low < high) {

            while (low < high && this.arr[low] <= pivot) {
                low++;
            }

            while (low <= high && this.arr[high] > pivot) {
                high--;
            }

            if (low < high) {
                swap(low, high);
            }
        }

        swap(start, high);

        quickSort(start, high - 1);

        quickSort(high + 1, stop);
    }

    private void swap(int i, int j) {

        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }
}

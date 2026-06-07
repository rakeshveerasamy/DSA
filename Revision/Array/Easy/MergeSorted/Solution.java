class MergeSorted {
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;
    private int[] result;

    MergeSorted(int[] nums1, int m, int[] nums2, int n) {
        this.nums1 = nums1;
        this.m = m;
        this.nums2 = nums2;
        this.n = n;
    }

    public void merge() {
        if (!isValid()) {
            this.result = new int[1];
            return;
        }

        this.result = new int[this.m + this.n];

        int i = 0, j = 0, k = 0;

        while (i < this.m && j < this.n) {

            if (this.nums1[i] <= this.nums2[j]) {
                this.result[k++] = this.nums1[i++];
            } else {
                this.result[k++] = this.nums2[j++];
            }
        }

        while (i < this.m) {
            this.result[k++] = this.nums1[i++];
        }
        while (j < this.n) {
            this.result[k++] = this.nums2[j++];
        }
    }

    public int[] getResult() {
        return this.result;
    }

    private boolean isValid() {
        return this.nums1 != null && this.nums2 != null;
    }
}

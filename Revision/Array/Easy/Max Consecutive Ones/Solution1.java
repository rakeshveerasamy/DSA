class MaxOnes {
    private int[] arr;

    MaxOnes(int[] arr) {
        this.arr = arr;
    }

    public int findMax() {
        if (!isValid()) {
            return 0;
        }

        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == 1) {
                maxEndingHere++;
            } else {
                maxEndingHere = 0;
            }

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;

    }

    private boolean isValid() {
        return this.arr != null && this.arr.length > 0;
    }
}

import java.util.HashMap;

class MaxSubarray {

    private int[] arr;
    private int k;

    MaxSubarray(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    private int findMax() {

        if (!isValid()) {
            return 0;
        }

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < this.arr.length; i++) {

            sum += this.arr[i];

            if (prefixSum.containsKey(sum - this.k)) {

                maxLength = Math.max(
                        maxLength,
                        i - prefixSum.get(sum - this.k));
            }

            prefixSum.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    private boolean isValid() {
        return this.arr != null && this.arr.length > 0;
    }

    public int getResult() {
        return this.findMax();
    }
}

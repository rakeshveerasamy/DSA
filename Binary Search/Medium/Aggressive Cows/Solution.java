import java.util.Arrays;

class AgressiveCow {

    private int[] nums;
    private int k;

    AgressiveCow(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }

    private boolean isValid() {
        return this.nums != null && this.nums.length > 0;
    }

    private int findMinMax() {

        if (!isValid()) {
            return -1;
        }

        Arrays.sort(this.nums);

        int low = 1;
        int high = this.nums[this.nums.length - 1] - this.nums[0];

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canPlace(int distance) {

        int count = 1;
        int lastPosition = this.nums[0];

        for (int i = 1; i < this.nums.length; i++) {

            if (this.nums[i] - lastPosition >= distance) {

                count++;
                lastPosition = this.nums[i];

                if (count == this.k) {
                    return true;
                }
            }
        }

        return false;
    }

    public int getResult() {
        return findMinMax();
    }
}

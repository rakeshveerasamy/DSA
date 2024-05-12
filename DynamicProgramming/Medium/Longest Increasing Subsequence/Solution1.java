class Solution {
    public int lengthOfLIS(int[] nums) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence(nums);
        return lis.getResult();
    }
}

class LongestIncreasingSubSequence {
	private int[] nums;
	private int size;
	private int maxLength;

	LongestIncreasingSubSequence(int[] nums) {
		this.nums = nums;
		this.maxLength = 0;

		if (isValid()) {
			this.size = nums.length;
			findLongestSubsequence();
		}
	}

	private boolean isValid() {
		return this.nums != null && this.nums.length != 0;
	}

	private void findLongestSubsequence() {
		this.maxLength = subsequenceHelper(0, -1);
	}

	private int subsequenceHelper(int index, int prev_index) {
		if (index == this.size) {
			return 0;
		}

		int notTake = 0 + subsequenceHelper(index + 1, prev_index);

		int take = 0;

		if (prev_index == -1 || this.nums[index] > this.nums[prev_index]) {
			take = 1 + subsequenceHelper(index + 1, index);
		}
		return Math.max(take, notTake);
	}
	
	public int getResult() {
		return this.maxLength;
	}
}

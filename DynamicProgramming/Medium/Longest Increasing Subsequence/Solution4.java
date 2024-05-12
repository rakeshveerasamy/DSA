/*Important*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(nums);
        return lis.getResult();
    }
}

class LongestIncreasingSubsequence {
	private int[] nums;
	private int size;
	private int maxLength;

	LongestIncreasingSubsequence(int[] nums) {
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
		List<Integer> seq = new ArrayList<>();

		for (int num : this.nums) {
			findSequence(seq, num);
		}
		this.maxLength = seq.size();
	}

	private void findSequence(List<Integer> seq, int num) {

		if (seq.isEmpty()) {
			seq.add(num);
			return;
		}

		int low = 0;
		int high = seq.size() - 1;

		while (low <high) {
			int mid = low + (high - low) / 2;

			if (seq.get(mid) >= num) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		if (seq.get(high) >= num) {
			seq.set(high, num);
		} else {
			seq.add(num);
		}
	}

	public int getResult() {
		return this.maxLength;
	}
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ThreeSum ts = new ThreeSum(nums);
        return ts.getThreeSum();
    }
}
class ThreeSum {
	private int[] nums;

	ThreeSum(int[] nums) {
		this.nums = nums;
	}

	public List<List<Integer>> getThreeSum() {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(this.nums);
		for (int i = 0; i < this.nums.length; i++) {
			if (i != 0 && this.nums[i] == this.nums[i - 1])
				continue;
			int j = i + 1;
			int k = this.nums.length - 1;
			while (j < k) {
				int sum = this.nums[i] + this.nums[j] + this.nums[k];
				if (sum > 0) {
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					List<Integer> temp = Arrays.asList(this.nums[i], this.nums[j], this.nums[k]);
					res.add(temp);
					j++;
					k--;
					while (j < k && this.nums[j] == this.nums[j - 1])
						j++;
					while (j < k && this.nums[k] == this.nums[k + 1])
						k--;
				}

			}
		}
		return res;
	}
}




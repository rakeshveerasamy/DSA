class Solution {
    public boolean canJump(int[] nums) {
        JumpGame jg = new JumpGame(nums);
        return jg.getResult();
    }
}
class JumpGame {
	private int[] nums;
	private int size;
	private boolean canJump;

	JumpGame(int[] nums) {
		this.nums = nums;
		this.canJump = false;

		if (isValid()) {
            this.size = nums.length;
			canJump();
		}
	}

	private boolean isValid() {
		return this.nums != null && this.nums.length != 0;
	}

	private void canJump() {
		int reachable = 0;

		if (this.size == 1) {
			this.canJump = true;
			return;
		}

		for (int i = 0; i < this.size; i++) {
			if (i > reachable) {
				return;
			}

			reachable = Math.max(reachable, i + this.nums[i]);
			if (reachable >= this.size - 1) {
				this.canJump = true;
				return;
			}
		}
	}

	public boolean getResult() {
		return this.canJump;
	}

}

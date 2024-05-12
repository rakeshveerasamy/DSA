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
        int dp [][] = new int [size][size+1];
        
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
		this.maxLength = subsequenceHelper(0, -1,dp);
	}

	private int subsequenceHelper(int index, int prev_index,int [][] dp) {
		if (index == this.size) {
			return 0;
		}
        
        if(dp[index][prev_index+1]!=-1){
            return dp[index][prev_index+1];
        }
        
		int notTake = 0 + subsequenceHelper(index + 1, prev_index,dp);

		int take = 0;

		if (prev_index == -1 || this.nums[index] > this.nums[prev_index]) {
			take = 1 + subsequenceHelper(index + 1, index,dp);
		}
		return dp[index][prev_index+1] = Math.max(take, notTake);
	}
	
	public int getResult() {
		return this.maxLength;
	}
}

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
        int dp [] = new int [this.size];
        Arrays.fill(dp,1);
        
        for(int i= 1;i<this.size;i++){
            for(int j = 0;j<=i;j++){
                if(this.nums[i]>this.nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
       
        for(int len:dp){
            this.maxLength =Math.max(this.maxLength,len);
        }
        
	}

	
	public int getResult() {
		return this.maxLength;
	}
}

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int nonZeroIndex = 0;
		int i;
		for( i = 0 ;i<nums.length;i++) {
			if(nums[i]!=0) {
			   nums[nonZeroIndex] = nums[i];
			   nonZeroIndex++;
			}
		}
		for(i = nonZeroIndex;i<nums.length;i++) {
			nums[i] = 0;
		}
    }
}

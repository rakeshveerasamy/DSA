// Time Complexity - O(n)


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int nonDuplicateIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[nonDuplicateIndex]!=nums[i]){
                nonDuplicateIndex++;
                nums[nonDuplicateIndex] = nums[i];
            }
        }
        return nonDuplicateIndex+1;
    }
}

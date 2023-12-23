//Time complexity O(n)
class Solution {
    public int removeDuplicates(int[] nums) {
        int k =2;
         if(nums.length<k) return nums.length;
        int i;
        int nonDuplicateIndex = 0;
        int duplicateLimit = 1;
        for ( i = 1;i<nums.length;i++) {
            if(nums[i] == nums[nonDuplicateIndex] && duplicateLimit<k){
                duplicateLimit++;
                nonDuplicateIndex++;
            }
           else  if(nums[i]!=nums[nonDuplicateIndex]){
                nonDuplicateIndex++;
                duplicateLimit =1;
            }
            nums[nonDuplicateIndex] = nums[i];

        }
        return  nonDuplicateIndex+1;
    }
}

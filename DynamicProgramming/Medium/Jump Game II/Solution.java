class Solution {
    public int jump(int[] nums) {
        if(nums == null)return 0;
        int len =nums.length;
        if(len<=1)return 0;
        int currMax = 0;
        int farMax = 0;
        int jump = 0;
        for(int i=0;i<len;i++){
            farMax = Math.max(farMax,i+nums[i]);
            if(farMax >= len-1){
                jump++;
                break;
            }
            if(i == currMax){
                currMax = farMax;
                jump++;
            }
        }
        return jump;
    }
}

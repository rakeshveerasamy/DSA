class Solution {
    public int findMaxLength(int[] nums) {
        //0,1,0,1,0,1,1,0,0,1,1,1,0
        /*
         zerocount: 6
         one count: 7        
        */
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for(int i =0;i<nums.length;i++){
            sum+=(nums[i] ==0)?-1:1;
            if(sumMap.containsKey(sum)){
                maxLength = Math.max(maxLength,i-sumMap.get(sum));
            }
            else{
            sumMap.put(sum,i);
            }
        }
        return maxLength;
    }
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        int sum = 0;
        int count =0;
        
        for(int num: nums){
            counter.put(sum, counter.getOrDefault(sum, 0) + 1);
            sum += num;
            count += counter.getOrDefault(sum - goal, 0);
        }
        return count;
    }
}

//better  - Array unsorted
//Time Complexity - O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> resMap = new HashMap<>();
		for(int i = 0;i<nums.length;i++){
			int remaining = target-nums[i];
			if(resMap.containsKey(remaining)) 
                return new int []{i,resMap.get(remaining)};
            resMap.put(nums[i] , i);
		}
		throw new IllegalArgumentException("Invalid array passed");
    }
}

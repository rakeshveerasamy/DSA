class Solution {
    public int subarraySum(int[] nums, int k) {
        CountSubarraySum cs = new CountSubarraySum(nums,k);
        return cs.subArraySumCount();
    }
}
class CountSubarraySum{
		private int[] nums;
		private int k;
		CountSubarraySum(int [] nums ,int k){
			this.nums = nums;
			this.k = k;
		}
		public int subArraySumCount() {
			Map<Integer,Integer> prefixSumCounter =  new HashMap<>();
			int prefixSum=0;
			int count = 0;
			prefixSumCounter.put(0, 1);
			
			for(int value :this.nums) {
				prefixSum+=value;
				
				if(prefixSumCounter.containsKey(prefixSum-this.k)) {
					count+=prefixSumCounter.get(prefixSum-this.k);
				}
				
				if(prefixSumCounter.containsKey(prefixSum)) {
					prefixSumCounter.replace(prefixSum, prefixSumCounter.get(prefixSum)+1);
				}else {
					prefixSumCounter.put(prefixSum,1);
				}
			}
			return count;
			
		}
}

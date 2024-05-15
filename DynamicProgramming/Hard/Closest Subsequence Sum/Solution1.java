class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        ClosestSum cs = new ClosestSum(nums , goal);
        return cs.getResult();
    }
}

class ClosestSum{
		private int []  nums;
		private int target;
		private int minDiff;
			
		ClosestSum(int [] nums , int target){
			this.nums = nums;
			this.target = target;
			this.minDiff = Integer.MAX_VALUE;
			
			if(isValid()) {
				findClosestSum();
			}
		}
		
		private boolean isValid() {
			return this.nums!=null && this.nums.length!=0 && this.minDiff!=0;
		}
		
		private List<Integer> findSubSetSum(int [] arr){
			int size = arr.length;
			
			List<Integer> res = new ArrayList<>();
			
			for(int mask = 0;mask<(1<<size);mask++) {
					int sum =0;
					for(int i=0;i<size;i++) {
							if((mask & (1<<i))!=0) {
								sum+=arr[i];
							}
					}
					res.add(sum);
			}
			return res;
		}
		
		private void findClosestSum() {
				
			int size = this.nums.length;
			
			List<Integer> leftSum = findSubSetSum(Arrays.copyOfRange(this.nums, 0, size/2));
			List<Integer> rightSum = findSubSetSum(Arrays.copyOfRange(this.nums,size/2,size));
			
			Collections.sort(rightSum);
			
			
			for(int left:leftSum) {
				
				int complement = this.target - left;
				int closestRightSum = findClosestSum(rightSum,complement);
				int closestDiff = Math.abs(this.target - (left+closestRightSum));
				this.minDiff = Integer.min(this.minDiff, closestDiff);
				
			}
		}
		
		private int findClosestSum(List<Integer> list, int target) {
			int low = 0;
			int high = list.size()-1;
			
			while(low<high) {
                int mid = low+(high-low)/2;
				if(list.get(mid)<target) {
					low = mid+1;
				}
				else {
					high = mid;
				}
			}
			if(low == 0) {
				return list.get(low);
			}
			else if (low == list.size()) {
				return list.get(low-1);
			}
			else {
				int closest = list.get(low);
				
				if(Math.abs(target-closest)> Math.abs(target - list.get(low-1))) {
					closest = list.get(low-1);
				}
				return closest;
			}
		}
		
		public int getResult() {
			return this.minDiff;
		}
		
		
}

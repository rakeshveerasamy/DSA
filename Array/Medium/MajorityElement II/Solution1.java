class Solution {
    public List<Integer> majorityElement(int[] nums) {
        MajorityElement mj =  new MajorityElement(nums);
        return mj.getMajorityElements();
    }
}
class MajorityElement{
		private int [] nums;
		MajorityElement(int [] nums){
				this.nums = nums;
		}
		public List<Integer> getMajorityElements(){
				List<Integer> res = new ArrayList<>();
				int candidate1 = 0;
				int candidate2 = 0;
				int count1=0;
				int count2 = 0;
				for(int value :this.nums) {
						if(value ==candidate1) count1++;
						else if (value == candidate2) count2++;
						else if (count1 == 0) {
							candidate1 = value;
							count1 = 1;
						}
						else if (count2 == 0) {
							candidate2 = value;
							count2 = 1;
						}
						else {
							count1--;
							count2--;
						}
				}
				count1 = count2 = 0;
				for(int value:this.nums) {
					if(value == candidate1) count1++;
					else if (value == candidate2) count2++;
				}
				
				if(count1>this.nums.length/3) res.add(candidate1);
				if(count2>this.nums.length/3) res.add(candidate2);
				return res;
		}
		
}

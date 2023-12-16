//Another approach 
//Time complexity -  O(n)


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
		int ans = 0 ;
		for (int i : nums) {
			sum*=i;
			sum+=i;
			ans  =  Math.max(sum , ans);
		}
        return ans;
    }
}

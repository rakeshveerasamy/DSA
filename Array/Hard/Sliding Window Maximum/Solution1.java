//Sliding window logic with deque 
//Time Complexity  =  O(n)
//Space Complexity = O(k) -  based on k value

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k<=0){
			return new int []{0};
		}
		
		int n = nums.length;
		int ro = 0;
		int [] result = new int [n-k+1];
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0;i<nums.length;i++){
			while(!deque.isEmpty() && deque.peek()<i-k+1){
				deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                result[ro++] = nums[deque.peek()];
            }
		}
        return result;
    }
}

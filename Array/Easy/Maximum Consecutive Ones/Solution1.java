//kadane's algorithm 
//Time Complexity  = O(n)



class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSoFar = 0 , maxEndingHere = 0;
        for(int i : nums) {
            if(i==0) maxEndingHere = 0;
            else maxEndingHere++;
            if(maxSoFar<maxEndingHere) maxSoFar = maxEndingHere;
        }
        return maxSoFar;

        
    }
}

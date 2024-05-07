class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxLen =Integer.MIN_VALUE;
        int maxFrequency = 0;
        int count[] = new int[26];
        
        for(int end = 0;end<s.length();end++){
                
            char currChar =s.charAt(end);
            count[currChar-'A']++;
            maxFrequency = Math.max(maxFrequency, count[currChar-'A']);
            
            while(end-start+1-maxFrequency>k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end-start+1);
            
        }
       return maxLen;

    }
}

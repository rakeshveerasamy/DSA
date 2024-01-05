//sliding window technique
//Time complexity -  O(n)
//Spac complexity -  O(Min(m,n)) m - 256 ascii charaters and n =  string 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character ,Integer> charIndex = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for(int end = 0;end<s.length();end++){
            if(charIndex.containsKey(s.charAt(end)) && charIndex.get(s.charAt(end))>=start) {
                start = charIndex.get(s.charAt(end))+1;
            }
            charIndex.put(s.charAt(end),end);
            maxLength =Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}

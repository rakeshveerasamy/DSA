class Solution {
    public String longestPalindrome(String s) {
        LongestPalindrome lp = new LongestPalindrome(s);
        return lp.longestPalindrome();
    }
}
class LongestPalindrome{
        private String str;
        LongestPalindrome(String str){
            this.str =str;
        }
        public String longestPalindrome(){
                if(this.str ==null || this.str.length()<=1){
                    return this.str;
                }
                String maxString = this.str.substring(0,1);
                for(int end = 0;end<this.str.length();end++){
                        String odd = this.expandFromCenter(end,end);
                        String even = this.expandFromCenter(end,end+1);
                        
                        if(odd.length()>maxString.length()){
                                maxString = odd;
                        }
                        if(even.length()>maxString.length()){
                            maxString = even;
                        }
                }
            return maxString;
        }
        private String expandFromCenter(int i, int j){
                while(i>=0 && j<this.str.length() && this.str.charAt(i) == this.str.charAt(j)){
                    i--;
                    j++;
                }
                return this.str.substring(i+1,j);
        }
}

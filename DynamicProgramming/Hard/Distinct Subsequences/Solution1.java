class Solution {
    public int numDistinct(String s, String t) {
        DistinctSubsequence ds =new DistinctSubsequence(s,t);
        return ds.getResult();
    }
}
class DistinctSubsequence{
        private String s;
        private String t;
        private int sLen;
        private int tLen;
        private int count;
        
        DistinctSubsequence(String s, String t){
            this.s =s;
            this.t =t;
            this.count =0;
                
            if(isValid()){
                   this.sLen = s.length();
                   this.tLen = t.length();
                    findDistinctCount();
            }
            
        }
    
        private boolean isValid(){
                return this.s!=null && this.t!=null && this.s.length()!=0 && this.t.length()!=0;
        }
        
        private void findDistinctCount(){
            int [][] dp =new int [this.sLen+1][this.tLen+1];
            
            for(int i=0;i<=this.sLen;i++){
                dp[i][0] = 1;
            }
            
            for(int i=1;i<=this.sLen;i++){
                for(int j=1;j<=this.tLen;j++){
                    if(this.s.charAt(i-1) == this.t.charAt(j-1)){
                            dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                    }
                    else{
                        dp[i][j ] = dp[i-1][j];
                    }
                }
            }
            this.count = dp[this.sLen][this.tLen];
            
        }
    
 
    
        public int getResult(){
            return this.count;
        }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int word1Size= word1.length();
        int word2Size = word2.length();
            
        int [][] dp =new int [word1Size+1][word2Size+1];
        
        for(int i=0;i<=word1Size;i++){
            dp[i][0] = i;
        }
        for(int i =0;i<=word2Size;i++){
            dp[0][i] = i;
        }
        
        for(int i =1;i<=word1Size;i++){
            for(int j=1;j<=word2Size;j++){
                if(word1.charAt(i-1) ==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
            
        }
        return dp[word1Size][word2Size];
    }
}

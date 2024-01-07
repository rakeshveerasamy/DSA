class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean [][]dp = new boolean [n+1][m+1];
        dp[0][0] = true;

        for(int i = 1;i<=m;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = (i-2 >= 0)&& dp[0][i-2];
            }
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);

                if(sChar == pChar || pChar == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pChar == '*'){
                    dp[i][j] = dp[i][j-2] ||(dp[i-1][j] && (sChar == p.charAt(j-2) || p.charAt(j-2)=='.'));
                }
            }
        }
        return dp[n][m];
    }


}

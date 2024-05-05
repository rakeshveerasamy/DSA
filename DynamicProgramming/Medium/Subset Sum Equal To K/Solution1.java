import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return findSubSet(k,arr,n);
    }

    private static boolean findSubSet(int k, int arr[],int n){
            if(arr == null || arr.length == 0){
                return false;
            }
            if(k == 0){
                return true;
            }

            boolean dp[][] = new boolean [n+1][k+1];

            for(int i=0;i<=n;i++){
                dp[i][0] = true;
            }
            for(int i=1;i<=k;i++){
                dp[0][i] = false;
            }
            for(int i=1;i<=n;i++){
                for(int j =1;j<=k;j++){
                    dp[i][j] = dp[i-1][j];
                    if(arr[i-1]<=j){
                        dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                    }
                }
            }
            return dp[n][k];
    }
}

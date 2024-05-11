import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
		int start =1;
		int stop = N-1;
		int dp[][] = new int [N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(dp[i] ,-1);
		}
		return matrixMultiplicationHelper(arr, start,stop,dp);

	}
	private static int matrixMultiplicationHelper(int [] arr , int start, int stop, int [][] dp){
		if(start == stop){
			return 0;
		}

		if(dp[start][stop]!=-1){
			return dp[start][stop];
		}
		int ans = Integer.MAX_VALUE;
		for(int k= start;k<=stop-1;k++){
			ans = Math.min(ans,matrixMultiplicationHelper(arr, start, k,dp)+matrixMultiplicationHelper(arr,k+1,stop,dp)+(arr[start-1]*arr[k]*arr[stop]));
		}
		dp[start][stop] = ans;
		return ans;
	}
}

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..

		int [] dp = new int [n];
		dp[0] = 0;

		for(int i=1;i<n;i++){
			int oneStep  = dp[i-1] + Math.abs(heights[i] - heights[i-1]);

			int twoStep = Integer.MAX_VALUE;

			if(i>1){
				twoStep = dp[i-2] + Math.abs(heights[i] - heights[i-2]);

			}

			dp[i]  = Math.min(oneStep, twoStep);
		}

		return dp[n-1];
    }

}

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int sum = 0;

		for(int num: arr){
			sum+=num;
		}

		if(d>sum) return 0;
		if((sum+d)%2!=0) return 0;

		int target = (sum+d)/2;

		return countSubSet(arr, target);
	}

	private static int countSubSet(int[] arr, int tar){
		int [] dp = new int[tar+1];
		dp[0] =1;
		int mod = 1000000007;

		for(int i=0;i<arr.length;i++){
			for(int target= tar; target>=arr[i];target--){
				dp[target] = (dp[target]+dp[target-arr[i]])%mod;
			}
		}

		return dp[tar];
	}
}

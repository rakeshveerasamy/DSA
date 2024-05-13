//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        LongestCommonString lcs = new LongestCommonString(S1,S2);
        return lcs.getResult();
    }
}
class LongestCommonString {
	private String str1;
	private String str2;
	private int str1Len;
	private int str2Len;
	private int length;

	LongestCommonString(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
		this.length = 0;

		if (isValid()) {
			this.str1Len = str1.length();
			this.str2Len = str2.length();
			findCommonSubstring();
		}
	}

	private boolean isValid() {
		return this.str1 != null && this.str2 != null && this.str1.length() != 0 && this.str2.length() != 0;
	}

	private void findCommonSubstring() {
		int[][] dp = new int[this.str1Len + 1][this.str2Len + 1];

		int max = 0;

		for (int i = 1; i <= this.str1Len; i++) {
			for (int j = 1; j <= this.str2Len; j++) {
				if (this.str1.charAt(i - 1) == this.str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		this.length = max;
	}

	public int getResult() {
		return this.length;
	}
}

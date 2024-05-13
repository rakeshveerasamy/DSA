class Solution {
    public int longestPalindromeSubseq(String s) {
        LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence(s);
        return lps.getResult();
    }
}
class LongestPalindromeSubsequence {
	private String str;
	private int size;
	private int palindromeLength;

	LongestPalindromeSubsequence(String str) {
		this.str = str;
		this.palindromeLength = 0;

		if (isValid()) {
			this.size = str.length();
			findPalindromeLength();
		}
	}

	private boolean isValid() {
		return this.str != null && this.str.length() != 0;
	}

	private void findPalindromeLength() {

		String reversed = new StringBuilder(this.str).reverse().toString();
		longestCommonSubsequence(this.str, reversed);

	}

	private void longestCommonSubsequence(String str1, String str2) {
		int[][] dp = new int[this.size + 1][this.size + 1];

		for (int i = 1; i <= this.size; i++) {
			for (int j = 1; j <= this.size; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
                else{
                    dp[i][j ] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
			}
		}

		this.palindromeLength = dp[this.size][this.size];
	}

	public int getResult() {
		return this.palindromeLength;
	}
}

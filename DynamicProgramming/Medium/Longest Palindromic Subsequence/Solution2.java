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
        
        int curr[] = new int[this.size+1];
        int prev[] = new int [this.size+1];

		for (int i = 1; i <= this.size; i++) {
			for (int j = 1; j <= this.size; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					curr[j] = 1 + prev[j - 1];
				}
                else{
                    curr[j ] =Math.max(prev[j],curr[j-1]);
                }
			}
            prev = curr.clone();
		}

		this.palindromeLength = curr[this.size];
	}

	public int getResult() {
		return this.palindromeLength;
	}
}

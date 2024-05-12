class Solution {
    public int longestStrChain(String[] words) {
        LongestStringChain lsc =new LongestStringChain(words);
        return lsc.getResult();
    }
}

class LongestStringChain {
	private String[] words;
	private int size;
	private int maxLen;

	LongestStringChain(String[] words) {
		this.words = words;
		this.maxLen = 0;

		if (isValid()) {
			this.size = words.length;
			findLongestStringChain();
		}
	}

	private boolean isValid() {
		return this.words != null && this.words.length != 0;
	}

	private void findLongestStringChain() {

		Arrays.sort(this.words, (x, y) -> (x.length() - y.length()));

		int[] dp = new int[this.size];
		
		Arrays.fill(dp, 1);

		for (int index = 0; index < this.size; index++) {
			for (int prev_index = 0; prev_index <= index - 1; prev_index++) {

				if (canPossible(this.words[index], this.words[prev_index]) && dp[prev_index] + 1 > dp[index]) {
					dp[index] = dp[prev_index] + 1;
				}
			}
			this.maxLen = Math.max(this.maxLen, dp[index]);
		}
	}

	private boolean canPossible(String curr, String prev) {
		if (curr == null && prev == null) {
			return true;
		}
		if ((curr == null || prev == null) || (curr.length() != prev.length() + 1)) {
			return false;
		}

		int first = 0;
		int second = 0;

		while (second < curr.length()) {
			if (first < prev.length() && prev.charAt(first) == curr.charAt(second)) {
				first++;
				second++;
			} else {
				second++;
			}
		}

		return first == prev.length() && second == curr.length();
	}

	public int getResult() {
		return this.maxLen;
	}
}

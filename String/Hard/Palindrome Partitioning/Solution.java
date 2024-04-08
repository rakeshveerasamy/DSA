class Solution {
	public List<List<String>> partition(String s) {
		PalindromePartitioning pp = new PalindromePartitioning(s);
		return pp.getPalindromeParition();
	}
}

class PalindromePartitioning {
	private String s;
	private int len;

	PalindromePartitioning(String s) {
		this.s = s;
		this.len = s.length();
	}

	public List<List<String>> getPalindromeParition() {
		List<List<String>> result = new ArrayList<>();
		List<String> decompose = new ArrayList<>();
		palindromePartitioningHelper(0, decompose, result);
		return result;
	}

	public void palindromePartitioningHelper(int index, List<String> decompose, List<List<String>> result) {
		if (index == this.len) {
			result.add(new ArrayList<>(decompose));
			return;
		}
		for (int i = index; i < this.len; i++) {
			String sub = this.s.substring(index, i + 1);
			if (isValidPalindrome(sub)) {
				decompose.add(sub);
				palindromePartitioningHelper(i + 1, decompose, result);
				decompose.remove(decompose.size() - 1);
			}
		}
	}

	private boolean isValidPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

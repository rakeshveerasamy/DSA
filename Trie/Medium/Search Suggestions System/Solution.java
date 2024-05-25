class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        SuggestedProducts sp = new SuggestedProducts(products,searchWord);
        return sp.getResult();
    }
}

class SuggestedProducts {
	private String[] products;
	private String searchWord;
	private List<List<String>> result;

	SuggestedProducts(String[] products, String searchWord) {
		this.products = products;
		this.searchWord = searchWord;
		this.result = new ArrayList<>();

		if (isValid()) {
			Arrays.sort(this.products);
			suggestedProducts();
		}
	}

	private boolean isValid() {
		return this.products != null && this.products.length > 0 && this.searchWord != null;
	}

	private TrieNode createTrieNode() {
		TrieNode root = new TrieNode();

		for (String product : this.products) {
			TrieNode curr = root;
			for (char ch : product.toCharArray()) {
				curr.child.putIfAbsent(ch, new TrieNode());
                curr = curr.child.get(ch);
				if (curr.suggestedProducts.size() < 3) {
					curr.suggestedProducts.add(product);
				}
			}
		}
		return root;
	}

	private List<String> suggestWord(String prefix, TrieNode root) {
		List<String> wordList = new ArrayList<>();
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {
			if (curr.child.containsKey(ch)) {
				curr = curr.child.get(ch);
				wordList = curr.suggestedProducts;
			}
            else{
                return new ArrayList<>();
            } 
		}
		return wordList;
	}

	private void suggestedProducts() {
		TrieNode root = createTrieNode();

		StringBuilder prefix = new StringBuilder();
		int len = this.searchWord.length();

		for (int i = 0; i < len; i++) {
			prefix.append(this.searchWord.charAt(i));
			this.result.add(suggestWord(prefix.toString(), root));
		}

	}

	public List<List<String>> getResult() {
		return this.result;
	}

}

class TrieNode {
	Map<Character, TrieNode> child;
	List<String> suggestedProducts;

	TrieNode() {
		this.child = new HashMap<>();
		this.suggestedProducts = new ArrayList<>();
	}
}

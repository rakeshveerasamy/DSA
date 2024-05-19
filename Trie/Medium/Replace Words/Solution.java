class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        ReplaceWord rw = new ReplaceWord(sentence,dictionary);
        return rw.getResult();
    }
}
class Trie {
	Map<Character, Trie> child;
	String word;

	Trie() {
		this.child = new HashMap<>();
		this.word = null;
	}
}

class ReplaceWord {
	private String word;
	private List<String> dictionary;
	private String result;

	ReplaceWord(String word, List<String> dictionary) {
		this.word = word;
		this.dictionary = dictionary;
		this.result = word;

		if (isValid()) {
			findAndReplace();
		}
	}

	private boolean isValid() {
		return this.word != null && this.dictionary != null;
	}

	private void findAndReplace() {
		Trie root = createTrie();

		StringBuilder res = new StringBuilder();

		for (String str : this.word.split("\\s+")) {
			if (res.length() > 0) {
				res.append(" ");
			}

			res.append(findRoot(str, root));

		}
		this.result = res.toString();
	}

	private Trie createTrie() {
		Trie root = new Trie();

		for (String str : this.dictionary) {
			Trie curr = root;
			for (char ch : str.toCharArray()) {
				if (!curr.child.containsKey(ch)) {
					curr.child.put(ch, new Trie());
				}
				curr = curr.child.get(ch);
			}
			curr.word = str;
		}
		return root;
	}

	private String findRoot(String str, Trie root) {

		Trie curr = root;

		for (char ch : str.toCharArray()) {
			if (!curr.child.containsKey(ch)) {
				break;
			}
			curr = curr.child.get(ch);
			if (curr.word != null) {
				return curr.word;
			}
		}
		return str;

	}
	public String getResult() {
			return this.result;
	}
}

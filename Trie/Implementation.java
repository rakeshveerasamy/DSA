class Node{
	Node [] link ;
	boolean isEnd;
	Node(){
		this.link =  new Node[26];
		this.isEnd = false;
	}
	public boolean containsKey(char ch) {
		return this.link[ch-'a']!=null;
	}
	public Node get(char ch) {
		return this.link[ch-'a'];
	}
	public void put(char ch,Node node) {
		this.link[ch-'a'] = node;
	}
	public boolean isEnd() {
		return this.isEnd;
	}
	public void setEnd() {
		this.isEnd = true;
	}
}
class Trie{
	
	private static Node root;
	Trie(){
		this.root = new Node();
	}
	public void insert(String word) {
		Node temp = this.root;
		for(char ch:word.toCharArray()) {
			if(!temp.containsKey(ch)) {
				temp.put(ch, new Node());
			}
			temp = temp.get(ch);
		}
		temp.setEnd();
			
	}
	public Node searchPrefix(String str) {
		Node temp = this.root;
		for(char ch:str.toCharArray()) {
			if(!temp.containsKey(ch)) {
				return null;
			}
			temp = temp.get(ch);
		}
		return temp;
	}
	
	public boolean search(String word) {
		Node temp = this.searchPrefix(word);
		return temp!=null && temp.isEnd();
	}
	public boolean startsWith(String str) {
		return this.searchPrefix(str)!=null;
	}
	
}

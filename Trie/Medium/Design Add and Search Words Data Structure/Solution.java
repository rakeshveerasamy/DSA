class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;

        for(char ch: word.toCharArray()){
            if(curr.child[ch-'a'] == null){
                curr.child[ch-'a'] =  new TrieNode();
            }
            curr = curr.child[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchWord(word,this.root);
    }

    public boolean searchWord(String word,TrieNode curr){
        int len = word.length();

        for(int i=0;i<len;i++){
            char currChar = word.charAt(i);

            if(currChar == '.'){
                for(TrieNode child:curr.child){
                    if(child!=null && searchWord(word.substring(i+1),child)){
                        return true;
                    }
                }
                return  false;
            }
            else{
                if(curr.child[currChar-'a'] == null){
                    return false;
                }
                curr = curr.child[currChar-'a'];
            }
        }
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 class TrieNode{
    TrieNode[] child;
    boolean isEnd;

    TrieNode(){
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
 }

class WordDictionary {

    public static Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {

        Node temp = this.root;

        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
        
    }
    
    public boolean search(String word) {

        return search(word, 0 ,this.root);
    }

    private boolean search(String word, int index, Node node){
        if(index == word.length()){
            return node.isEnd();
        }

        char ch = word.charAt(index);

        if(ch!='.'){

            if(!node.containsKey(ch)){
                return false;
            }

            return search(word, index+1, node.get(ch));
        }

        for(int i=0;i<26;i++){
            
            if(node.link[i]!=null){
                if(search(word, index+1, node.link[i])){
                    return true;
                }
            }
        }

        return false;
    }
}

class Node{
    Node[] link;
    boolean isEnd;

    Node(){
        this.link = new Node[26];
        this.isEnd = false;
    }

    public boolean containsKey(char ch){
        return this.link[ch-'a']!=null;
    }

    public Node get(char ch){
        return this.link[ch-'a'];
    }

    public void put(char ch , Node node){
        this.link[ch-'a'] = node;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

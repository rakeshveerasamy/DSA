class Solution {
    public String longestString(String[] words) {
        // code here
        
        Trie trie = new Trie();
        
        for(String word: words){
            trie.insert(word);
        }
        
        String result = "";
        
        for(String word: words){
            
            if(trie.allPrefixWord(word)){
                
                if(result.length()<word.length()){
                    result = word;
                }
                
                if(result.length() == word.length() && word.compareTo(result)<0){
                    result = word;
                }
            }
        }
        return result;
    }
}

class Trie{
    private static Node root;
    
    Trie(){
        this.root = new Node();
    }
    
    public void insert(String word){
        Node temp = this.root;
        
        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                temp.put(ch, new Node());
            }
            
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    
    public boolean allPrefixWord(String word){
        Node temp = this.root;
        
        
        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                return false;
            }
            
            temp = temp.get(ch);
            
            if(!temp.isEnd()){
                return false;
            }
        }
        
        return true;
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
    
    public void put(char ch , Node node){
        this.link[ch-'a'] = node;
    }
    
    public Node get(char ch){
        return this.link[ch-'a'];
    }
    
    public boolean isEnd(){
        return this.isEnd;
    }
    
    public void setEnd(){
        this.isEnd = true;
    }
}

import java.util.* ;
import java.io.*; 
public class Trie {

    private Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node temp = this.root;

        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
            temp.increasePrefix();
        }

        temp.increaseWordCount();
        temp.setEnd();
    }

    public int countWordsEqualTo(String word) {
        Node temp = this.root;

        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                return 0;
            }
            temp = temp.get(ch);
        }

        return temp.getWordCount();
    }

    public int countWordsStartingWith(String word) {
        Node temp = this.root;

        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                return 0;
            }
            temp = temp.get(ch);
        }

        return temp.getPrefixCount();
    }

    public void erase(String word) {
        Node temp = this.root;

        for(char ch: word.toCharArray()){
            if(!temp.containsKey(ch)){
                return ;
            }
            temp = temp.get(ch);
            temp.decreasePrefix();
        }

        temp.decreaseWordCount();
    }

}

class Node{
    private Node [] links;
    private boolean isEnd;
    private int countEnd;
    private int countPrefix;

    Node(){
        this.links = new Node[26];
        this.isEnd = false;
        this.countEnd = 0;
        this.countPrefix = 0;
    }

    public boolean containsKey(char ch){
        return this.links[ch-'a']!=null;
    }

    public Node get(char ch){
        return this.links[ch-'a'];
    }

    public void put(char ch, Node node){
        this.links[ch-'a'] = node;
    }

    public void increasePrefix(){
        this.countPrefix++;
    }
    public void decreasePrefix(){
        this.countPrefix--;
    }

    public void increaseWordCount(){
        this.countEnd++;
    }

    public void decreaseWordCount(){
        this.countEnd--;
    }

    public boolean isEnd(){
        return this.isEnd;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public int getPrefixCount(){
        return this.countPrefix;
    }

    public int getWordCount(){
        return this.countEnd;
    }
}

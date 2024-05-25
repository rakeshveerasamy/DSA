
class Solution {
    public String longestWord(String[] words) {
        LongestWord lw = new LongestWord(words);
        return lw.getResult();
    }
}

class TrieNode{
    Map<Character,TrieNode> child;
    String word;
    
    TrieNode(){
        this.child = new HashMap<>();
        this.word = null;
    }
}

class LongestWord{
    private String[] word;
    private String result;

    LongestWord(String [] word){
        this.word = word;
        this.result = result;

        if(isValid()){
            findLongestWord();
        }
    }

    private boolean isValid(){
        return this.word!=null && this.word.length>0;
    }

    private TrieNode createTrie(){
        TrieNode root = new TrieNode();

        for(String currWord: this.word){

            TrieNode curr= root;
            for(char ch: currWord.toCharArray()){
                curr.child.putIfAbsent(ch,new TrieNode());
                curr = curr.child.get(ch);
            }
            curr.word =currWord;

        }
        return root;
    }

    private void findLongestWordInDictionary(TrieNode root){
        String res = "";
        Queue<TrieNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            TrieNode curr = que.poll();
            for(TrieNode child : curr.child.values()){
                if(child.word!=null){
                    que.offer(child);

                    if(res.length()<child.word.length()  || (res.length() == child.word.length() && child.word.compareTo(res)<0) ){
                        res= child.word;
                    }
                }
            }
        }
        this.result = res;
        
    }

    private void findLongestWord(){
        TrieNode root= createTrie();

        findLongestWordInDictionary(root);
            
    }
    public String getResult(){
        return this.result;
    }
}

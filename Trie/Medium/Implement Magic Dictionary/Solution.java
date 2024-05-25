class MagicDictionary {

    private TrieNode root;

    public MagicDictionary() {
        this.root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            TrieNode curr = this.root;
            for(char ch:word.toCharArray()){
            
                if(curr.link[ch-'a']==null){
                    curr.link[ch-'a']= new TrieNode();
                }

                curr = curr.link[ch-'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return searchWordInDict(searchWord.toCharArray(),0,this.root,false);
    }

    private boolean searchWordInDict(char[] word,int index,TrieNode curr,boolean isModified){
        if(index == word.length){
            return isModified&curr.isEnd;
        }

        int charIndex = word[index]-'a';

        if(curr.link[charIndex]!=null){
            if(searchWordInDict(word,index+1,curr.link[charIndex],isModified)){
                return true;
            }
        }

        if(!isModified){
            for(int i=0;i<26;i++){
                if(i!=charIndex && curr.link[i]!=null){
                    if(searchWordInDict(word,index+1,curr.link[i],true)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class TrieNode{
    TrieNode[] link;
    boolean isEnd;

    TrieNode(){
        this.link = new TrieNode[26];
        this.isEnd = false;
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        TrieNode root =createTrie(wordDict);
        
        List<String> res = new ArrayList<>();
        
        dfs(0,s,res,"",root);
        
        return res;
    }
    private TrieNode createTrie(List<String> wordDict){
        
        TrieNode root = new TrieNode();
        
        for(String str: wordDict){
             
            TrieNode curr = root;
                
            for(char ch: str.toCharArray()){
                curr.child.putIfAbsent(ch,new TrieNode());
                curr = curr.child.get(ch);
            }
            curr.isEnd = true;
        }
        return root;
    }
    private void dfs(int index , String s, List<String> res,String path , TrieNode root){
        int len = s.length();
        
        if(index == len){
            res.add(path.trim());
            return;
        }
        TrieNode curr = root;
        for(int i =index;i<len;i++){
            char ch = s.charAt(i);
            
            if(!curr.child.containsKey(ch)){
                break;
            }
            curr= curr.child.get(ch);
            
            if(curr.isEnd){
                dfs(i+1,s,res,path+s.substring(index,i+1)+" ",root);
            }
        }
    }
}
class TrieNode{
    Map<Character,TrieNode> child;
    boolean isEnd;
    
    TrieNode(){
        this.child =new HashMap<>();
        this.isEnd=false;
    }
}

/*
cat
sand
dog

cats
and
dog

*/

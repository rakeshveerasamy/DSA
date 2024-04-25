class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root= new Trie();
        for(int num:nums){
            root.insert(num);
        }
        int max = 0;
        for(int num:nums){
            max = Math.max(max,root.getMax(num));
        }
        return max;
    }
}
class Node{
    Node[] link ;
    Node(){
        this.link = new Node[2];
    }
    public boolean containsKey(int bit){
        return this.link[bit]!=null;
    }
    public void put(int bit , Node node){
            this.link[bit] = node;
    }
    public Node get(int bit){
        return this.link[bit];
    }
    
}
class Trie{
    Node root;
    
    Trie(){
        this.root = new Node();
    }
    public void insert(int num){
        Node curr = this.root;
        for(int i =31;i>=0;i--){
            int bit = num>>i &1;
            if(!curr.containsKey(bit)){
                curr.put(bit,new Node());
            }
            curr = curr.get(bit);
        }
    }
    public int getMax(int num){
        int max =0;
        Node curr =this.root;
        for(int i =31;i>=0;i--){
            int bit = (num>>i) &1;
            if(curr.containsKey(1-bit)){
                max|=(1<<i);
                curr = curr.get(1-bit);
            }
            else{
                curr = curr.get(bit);
            }
        }
        return max;
    }
}

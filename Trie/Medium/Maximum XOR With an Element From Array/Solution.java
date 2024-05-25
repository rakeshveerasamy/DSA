class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        MaximumXOR mx = new MaximumXOR(nums,queries);
        return mx.getResult();
    }
}

class MaximumXOR{
    private int[] nums;
    private int [][] queries;
    private List<List<Integer>> offlineQuery;
    private int numLen;
    private int queryLen;
    private int[] result;


    MaximumXOR(int [] nums , int [][] queries){
        this.nums = nums;
        this.queries = queries;
        this.result = null;

        if(isValid()){
            this.offlineQuery = new ArrayList<>();
            this.numLen = nums.length;
            this.queryLen = queries.length;
            this.result = new int [this.queryLen];
            initialize();
            findMaxXOR();
        }

    } 

    private boolean isValid(){
        return this.nums!=null && this.nums.length!=0 
        && this.queries!=null && this.queries.length>0 
        && this.queries[0].length == 2;
    }

    private void initialize(){
        int ind = 0;
        for(int [] query: this.queries){
            List<Integer> temp = new ArrayList<>();
            temp.add(query[1]);
            temp.add(query[0]);
            temp.add(ind++);
            this.offlineQuery.add(temp);
        }

        Arrays.fill(this.result,-1);

    }

    private void findMaxXOR(){
        Collections.sort(this.offlineQuery,(list1,list2)->(list1.get(0) - list2.get(0)));
        Arrays.sort(this.nums);

        TrieNode root = new TrieNode();
        
        int ind =0;

        for(int i=0;i<this.queryLen;i++){

            while(ind<this.numLen && this.offlineQuery.get(i).get(0)>=this.nums[ind]){
                root.insert(this.nums[ind]);
                ind++;
            }
            if(ind!=0) this.result[this.offlineQuery.get(i).get(2)] = root.getMax(this.offlineQuery.get(i).get(1)); 
        }

    }

    public int[] getResult(){
        return this.result;
    }
}

class Node{
    Node [] link;
    Node(){
        this.link = new Node[2];
    }
    public boolean containsKey(int num){
        return (this.link[num]!=null);
    }
    public Node get(int num){
        return this.link[num];
    }
    public void put(int num , Node node){
        this.link[num] = node;
    }
}
class TrieNode{
    Node root;

    TrieNode(){
        this.root = new Node();
    }

    public void insert(int num){
        Node curr =this.root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;

            if(!curr.containsKey(bit)){
                curr.put(bit,new Node());
            }
            curr = curr.get(bit);
        }
    }
    public int getMax(int num){
        Node curr = this.root;
        int max = 0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) &1;
            if(curr.containsKey(1-bit)){
                max = max |(1<<i);
                curr = curr.get(1-bit);
            }
            else{
                curr = curr.get(bit);
            }
        }
        return max;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        RedundantConnection rc = new RedundantConnection(edges);
        return rc.getResult();
    }
}

class DisjointSet{
    int vertices;
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int vertices){
        this.vertices =vertices;
        this.parent = new ArrayList<>();
        this.size =new ArrayList<>();
        initialize();
    }

    private void initialize(){
        for(int i=0;i<=this.vertices;i++){
            this.parent.add(i);
            this.size.add(1);
        }
    }

    public int findUltimateParent(int node){
        if(node ==  this.parent.get(node)){
            return node;
        }
        int par =findUltimateParent(this.parent.get(node));
        this.parent.set(node,par);
        return par;
    }
    
    public void unionBySize(int u, int v){
        int uParent = findUltimateParent(u);
        int vParent= findUltimateParent(v);

        if(vParent == uParent) return;

        if(this.size.get(uParent)<this.size.get(vParent)){
            this.parent.set(uParent,vParent);
            this.size.set(vParent, this.size.get(uParent)+this.size.get(vParent));
        }
        else{
            this.parent.set(vParent,uParent);
            this.size.set(uParent, this.size.get(uParent)+this.size.get(vParent));
        }
    }

}

class RedundantConnection{
    private int [][] edges;
    private int vertices;   
    private int[] res;

    RedundantConnection(int [][] edges){
        this.edges =edges;
        this.res = new int[2];

        if(isValid()){
            this.vertices= edges.length;
            findRedundantConnection();
        }
    }

    private boolean isValid(){
        return this.edges!=null && this.edges.length!=0 && this.edges[0].length==2;
    }

    private void findRedundantConnection(){
            DisjointSet set = new DisjointSet(this.vertices);
            
            for(int edge[]: this.edges){
                int u = edge[0];
                int v = edge[1];
                
                if(set.findUltimateParent(u)!=set.findUltimateParent(v)){
                    set.unionBySize(u,v);
                }
                else{
                    this.res = new int[]{u,v};
                    return;
                }
            }
    }
    public int[] getResult(){
        return this.res;
    }
}

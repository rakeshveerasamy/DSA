class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        SafeNode sn =new SafeNode(graph);
        return sn.getResult();
    }
}

class SafeNode{
        private int [][] graph;
        private List<List<Integer>> adjList;
        private int vertices;
        private List<Integer> result;
        private int[] indegree;

        SafeNode(int [][] graph){
            this.graph = graph;
            this.result = new ArrayList<>();
            
            if(isValid()){
                    this.adjList= new ArrayList<>();
                    this.vertices = graph.length;
                    this.indegree = new int[this.vertices];
                    initialize();
                    findSafeNode();
            }
        }

        private boolean isValid(){
            return this.graph!=null && this.graph.length!=0;
        }

        private void initialize(){
                for(int i=0;i<this.vertices;i++){
                    this.adjList.add(new ArrayList<>());
                }
                for(int i=0;i<this.vertices;i++){
                    for(int neighbour:this.graph[i]){
                        this.adjList.get(neighbour).add(i);
                    }
                }

                for(int i=0;i<this.vertices;i++){
                        for(int neighbour:this.adjList.get(i)){
                            this.indegree[neighbour]++;
                        }
                }
        }

        private void findSafeNode(){
                Queue<Integer> que =new LinkedList<>();

                for(int i=-0;i<this.vertices;i++){
                    if(this.indegree[i] == 0){
                        que.offer(i);
                    }
                }

                while(!que.isEmpty()){
                    int curr = que.poll();
                    this.result.add(curr);

                    for(int neighbour: this.adjList.get(curr)){
                        this.indegree[neighbour]--;
                        if(this.indegree[neighbour]==0){
                            que.offer(neighbour);
                        }
                    }
                }
                Collections.sort(this.result);
        }

        public List<Integer> getResult(){
            return this.result;
        }


}

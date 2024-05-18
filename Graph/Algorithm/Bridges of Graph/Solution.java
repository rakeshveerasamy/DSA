class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        BridgeInGraph big = new BridgeInGraph(connections,n);
        return big.getResult();
    }
}
class BridgeInGraph {
    private List<List<Integer>> edges;
    private int vertices;
    private int[] discovery;
    private int[] earliestReachable;
    private List<List<Integer>> graph;
    private List<List<Integer>> bridges;
    private boolean[] visited;
    private int time;


    BridgeInGraph(List<List<Integer>> edges, int vertices) {
        this.edges = edges;
        this.vertices = vertices;
        this.bridges = new ArrayList<>();


        if (isValid()) {
            this.time = 0;
            this.discovery = new int[this.vertices];
            this.earliestReachable = new int[this.vertices];
            this.visited = new boolean[this.vertices];
            this.graph = new ArrayList<>();
            this.bridges = new ArrayList<>();
            constructGraph();
            findBridges();


        }
    }


    private boolean isValid() {
        return this.edges != null && this.edges.size() != 0 && this.edges.get(0).size() == 2 && this.vertices != 0;
    }


    private void constructGraph() {
        for (int i = 0; i < this.vertices; i++) {
            this.graph.add(new ArrayList<>());
        }


        for (int i = 0; i < this.edges.size(); i++) {
            this.graph.get(this.edges.get(i).get(0)).add(this.edges.get(i).get(1));
            this.graph.get(this.edges.get(i).get(1)).add(this.edges.get(i).get(0));
        }
    }


    private void findBridges() {
        dfs(0, -1);
    }


    private void dfs(int child, int parent) {
        this.visited[child] = true;
        this.discovery[child] = this.earliestReachable[child] = this.time++;


        for (int v : this.graph.get(child)) {
            if (v == parent)
                continue;


            if (!this.visited[v]) {
                dfs(v, child);
                this.earliestReachable[child] = Math.min(this.earliestReachable[v], this.earliestReachable[child]);


                if (this.earliestReachable[v] > this.discovery[child]) {
                    this.bridges.add(Arrays.asList(child, v));
                }
            } else {
                this.earliestReachable[child] = Math.min(this.earliestReachable[child], this.earliestReachable[v]);
            }
        }
    }


    public List<List<Integer>> getResult() {
        return this.bridges;
    }
}




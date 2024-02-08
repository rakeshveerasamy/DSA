class Graph{
	private int vertices;
	private List<List<Integer>> adjacencyList;
	public Graph(int vertices) {
		this.vertices = vertices;
		this.adjacencyList = new ArrayList<>();
		for(int i =0;i<this.vertices;i++){
			this.adjacencyList.add(new ArrayList<>());
		}
	}
	public void addEdge(int from , int to){
		this.adjacencyList.get(from).add(to);
		this.adjacencyList.get(to).add(from);
	}
	public List<Integer> getNeighbours(int vertex){
		return this.adjacencyList.get(vertex);
	}
}

class Solution {

    public int findCircleNum(int[][] isConnected) {
         int provinces = 0;

        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0){
		    return provinces;
	    }
	    int row = isConnected.length;
        
        Graph  graph = new Graph(row);
        boolean [] visited =  new boolean[row];
        
	    for(int  i =0;i<row;i++){
	    	for(int j = i+1;j<row;j++){
	    		if(isConnected[i][j] ==1){
	    			graph.addEdge(i,j);
		    	}
		    }
	    }
	
	    for(int i = 0;i<row;i++){
	    	if(!visited[i] ){
                 dfs(graph, visited,i);
                 provinces++;
              }	
	    }
        return provinces;
    }
    private void dfs(Graph graph , boolean [] visited, int city){
    visited[city] = true;
    for(int vertices:graph.getNeighbours(city)){
        if(!visited[vertices]){
            dfs(graph, visited, vertices);
        }
    }	
}

}

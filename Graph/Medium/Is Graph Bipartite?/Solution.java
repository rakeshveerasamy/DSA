/*
The time complexity of the checkBipartite() method in the BipartiteGraph class is O(V+E), where V is the number of vertices and E is the number of edges in the graph. This is because the method iterates through each vertex and its neighbors once to check if the graph is bipartite.

The space complexity of the BipartiteGraph class is O(V), where V is the number of vertices in the graph. This is because we are storing the visited array of size V to keep track of the colors assigned to each vertex.

Overall, the time complexity is O(V+E) and the space complexity is O(V) for the BipartiteGraph class.

*/


class Solution {
    public boolean isBipartite(int[][] graph) {
        BipartiteGraph bg = new BipartiteGraph(graph);
        return bg.getResult();
    }
}

class BipartiteGraph{
private int [][] graph;
private int row;
private int [] visited;
private boolean isBipartite;

BipartiteGraph(int [][] graph){
this.graph =graph;
this.isBipartite = false;
if(isValid()){
	this.row = graph.length;
	this.visited = new int[row];
	init();
	checkBipartite();
}
}	
private boolean isValid(){
return this.graph!=null & this.graph.length!=0;	
}
private void init(){
	Arrays.fill(this.visited,-1);
}	
private void checkBipartite(){
	int color =1;
	this.visited[0] = color;
	for(int i=0;i<this.row;i++){
		color = 1-this.visited[i];
		for(int neighbour: this.graph[i]){
			if(this.visited[i]!=-1 && this.visited[neighbour] == this.visited[i]){
				this.isBipartite = false;
				return;
			}
			this.visited[neighbour] = color;
		}
	}	
	this.isBipartite = true;
}	
public boolean getResult(){
return this.isBipartite;	
}
}


import java.util.*;

public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
        SortestPath sp = new SortestPath(edge,edges,vertices,source);
        sp.findSortestPath();
		return sp.getResult();
    }
}

class Node {
		
	int id;
	int distance;
		
	Node(int id,int distance){
			this.id =id;
			this.distance =distance;
	}
}
class SortestPath{
		private int[][] edge;
		private int edges;
		private int vertices;
		private int source;
		private int [] distance;
		private List<List<Node>> adjList;
		
		SortestPath(int[][] edge, int edges,int vertices,int source){
				this.edge = edge;	
				this.edges =edges;
				this.vertices = vertices;
				this.source = source;
				this.adjList = new ArrayList<>();
				this.distance = new int [this.vertices];
				init();
		}
		private void init() {
				for(int i =0;i<this.vertices;i++) {
						this.adjList.add(new ArrayList<>());
						this.distance[i] = Integer.MAX_VALUE;
				}
				constructGraph();
		}
		private void addEdges(int source, int des , int distance) {
				this.adjList.get(source).add(new Node(des,distance));
				this.adjList.get(des).add(new Node(source,distance));
		}
		private void constructGraph() {
			for(int i=0;i<this.edges;i++) {
				addEdges(this.edge[i][0],this.edge[i][1],this.edge[i][2]);
			}
		}
		public  void findSortestPath() {
			PriorityQueue<Node> minHeap=new PriorityQueue<>((x,y)->(x.distance-y.distance));
			this.distance[this.source] = 0;
			minHeap.add(new Node(this.source,0));
			
			while(!minHeap.isEmpty()) {
				Node curr = minHeap.poll();
				
				if(curr.distance > this.distance[curr.id]) continue;
				
				for(Node neighbour: this.adjList.get(curr.id)) {
					
					int neighbourDistance= curr.distance+neighbour.distance;
					
					if(neighbourDistance<this.distance[neighbour.id]) {
						this.distance[neighbour.id] = neighbourDistance;
						minHeap.add(new Node (neighbour.id,neighbourDistance));
					}
					
				}
			}
		}
		
		public List<Integer> getResult(){
				List<Integer> result = new ArrayList<>();
				for(int num:this.distance){
					result.add(num);
				}
				return result;
		}
}

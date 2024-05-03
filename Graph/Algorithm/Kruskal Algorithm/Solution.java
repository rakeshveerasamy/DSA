/*

The time complexity of Kruskal's algorithm is O(E log E), where E is the number of edges in the graph. 
This is because the algorithm sorts all the edges based on their weights, which takes O(E log E) time. 
Then, for each edge, it performs a find operation and a union operation on the disjoint sets, which takes nearly constant time.
Overall, the time complexity is dominated by the sorting step.

The space complexity of Kruskal's algorithm is O(V), where V is the number of vertices in the graph. 
This is because we are storing the parent and size arrays for the disjoint set data structure, which requires O(V) space.
*/

import java.util.*;
public class Solution {
    public static int kruskalMST(int n,int [][]edges) {
        //Write your code here
        KruskalAlgo ka = new KruskalAlgo(edges,n);
        return ka.getResult();
    }
}

class Edge implements Comparable<Edge>{
int src;
int des;
int weight;

Edge(int src, int des, int weight){
	this.src= src;
	this.des =des;
	this.weight =weight;
}	
public int compareTo(Edge compare){
return this.weight - compare.weight;	
}
}

class DisjointSet{
private int vertices;
private List<Integer> parent;
private List<Integer> size;

DisjointSet(int vertices){
	this.vertices =  vertices;
	this.parent =new ArrayList<>();
	this.size = new ArrayList<>();
	init();
}	
	
private void init(){
for(int i=0;i<=this.vertices; i++){
this.parent.add(i);
this.size.add(1);
}	
}

public  int findUltimateParent(int node){
if(node == this.parent.get(node)){
	return node;
}	

int par = findUltimateParent(this.parent.get(node));
this.parent.set(node,par);
return this.parent.get(node);
}

public void addDisjointSet(int u,int v){
int uParent = findUltimateParent(u);	
int vParent = findUltimateParent(v);
	
if(uParent == vParent) return;
if(this.size.get(uParent) < this.size.get(vParent)){
	this.parent.set(uParent,vParent);
	this.size.set(vParent, this.size.get(vParent)+1);
}
else{
	this.parent.set(vParent,uParent);
	this.size.set(uParent, this.size.get(uParent)+1);
}
	}
}

class KruskalAlgo{
private int [][] edges;
private int vertices;
private int minWeight;

KruskalAlgo(int [][] edges, int vertices){
	this.edges =  edges;
	this.vertices = vertices;
	this.minWeight = 0;
	
	if(isValid()){
		constructDisjointSet();
	}
}	
	
private boolean isValid(){
return this.edges!=null && this.edges.length!=0 && this.edges[0].length==3;	
}

private void constructDisjointSet(){
   	
	List<Edge> set  =  new ArrayList<>();

	for(int i=0;i<this.edges.length;i++){
		int src = this.edges[i][0];
		int des = this.edges[i][1];
		int weight = this.edges[i][2];

		set.add(new Edge(src,des,weight));
		set.add(new Edge(des,src,weight));
	}
	Collections.sort(set);
	
	DisjointSet djs =new DisjointSet(this.vertices);
	for(int i=0;i<set.size();i++){
		Edge curr = set.get(i);
		if(djs.findUltimateParent(curr.src) != djs.findUltimateParent(curr.des)){
			this.minWeight+=curr.weight;
			djs.addDisjointSet(curr.src,curr.des);
		}
	}
}
public int getResult(){
return this.minWeight;	
}
	

}

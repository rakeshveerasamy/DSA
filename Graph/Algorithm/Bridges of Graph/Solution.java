import java.util.*;

import com.sun.org.apache.xpath.internal.axes.ChildTestIterator;
public class Solution {

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {

        // Write your code here!
        Bridge b = new Bridge(v,edges);
        return b.getResult();

    }
}
class Bridge{
    private int vertices;
    private int [][] edges;
    private List<List<Integer>> graph;
    private int [] discoveryTime;
    private int []  earliestReachable ;
    private boolean [] visited;	
    private List<List<Integer>>bridges;
    private int time;

    Bridge(int vertices , int [][] edges){
        this.vertices = vertices;
        this.edges = edges;
        this.bridges = new ArrayList<>();

        if(isValid()){
            this.graph = new ArrayList<>();
            this.discoveryTime = new int [this.vertices];
            this.earliestReachable = new int [this.vertices];
            this.visited = new boolean [this.vertices];
            this.time = 0;
            constructGraph();
            findBridges();
        }	
    }

    private boolean isValid(){
        return  this.edges!=null & this.edges.length!=0 && this.edges[0].length==2;
    }	

    private void constructGraph(){
        for(int i=0;i<this.vertices;i++){
            this.graph.add(new ArrayList<>());
        }	

        for(int i=0;i<this.edges.length;i++){
            this.graph.get(this.edges[i][0]).add(this.edges[i][1]);
            this.graph.get(this.edges[i][1]).add(this.edges[i][0]);
        }
    }
    private void findBridges(){
        dfs(0,-1);
    }
    private void dfs(int child, int parent){
        this.visited[child] =  true;
        this.discoveryTime[child] =  this.earliestReachable[child] = ++this.time;

        for(int v : this.graph.get(child)){
            if(v == parent) continue;

            if(!this.visited[v]){
                dfs(v,child);
                this.earliestReachable[child] = Math.min(this.earliestReachable[v], this.earliestReachable[child]);
                if(this.earliestReachable[v]>this.discoveryTime[child]){
                    this.bridges.add(Arrays.asList(child,v));
                }

            }else{
                this.earliestReachable[child] = Math.min(this.earliestReachable[child] , this.discoveryTime[v]);
            }	
        }
    }
    public List<List<Integer>> getResult(){
        return this.bridges;	
    }
}

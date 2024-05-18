package com.sample;

import java.util.*;

public class practice {

	public static void main(String[] args) {
			List<List<Integer>> adj = new ArrayList<>();
			adj.add(Arrays.asList(0,1));
			adj.add(Arrays.asList(1,4));
			adj.add(Arrays.asList(2,4));
			adj.add(Arrays.asList(3,4));
			adj.add(Arrays.asList(2,3));
			int num =5;
			
			ArticulationPoint ap = new ArticulationPoint(adj,num);
			System.out.println(ap.getResult());
	}

}

class ArticulationPoint {
	private List<List<Integer>> edges;
	private int vertices;
	private int[] discovery;
	private int[] earliestReachable;
	private boolean[] visited;
	private List<List<Integer>> graph;
	private List<Integer> points;
	private int time;

	ArticulationPoint(List<List<Integer>> edges, int vertices) {
		this.edges = edges;
		this.vertices = vertices;
		this.points = new ArrayList<>();

		if (isValid()) {
			this.discovery = new int[vertices];
			this.earliestReachable = new int[vertices];
			this.visited = new boolean[vertices];
			this.graph = new ArrayList<>();
			this.time = 0;
			constructGraph();
			findArticulationPoint();
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

	private void findArticulationPoint() {
		for (int i = 0; i < this.vertices; i++) {
			if (!this.visited[i]) {
				dfs(i, -1);
			}
		}
	}

	private void dfs(int child, int parent) {
		this.visited[child] = true;
		this.discovery[child] = this.earliestReachable[child] = this.time++;
		int childCount = 0;

		for (int v : this.graph.get(child)) {
			if (v == parent)
				continue;

			if (!this.visited[v]) {
				dfs(v, child);
				this.earliestReachable[child] = Math.min(this.earliestReachable[child], this.earliestReachable[v]);

				if (this.earliestReachable[v] >= this.discovery[child] && parent != -1) {
					this.points.add(child);
				}
			} else {
				this.earliestReachable[child] = Math.min(this.earliestReachable[child], this.discovery[v]);
			}
			childCount++;
		}

		if (childCount > 1 && parent == -1) {
			this.points.add(child);
		}
	}

	public List<Integer> getResult() {
		return this.points;
	}

}

class BaconNumber{
private Map<String , List<String>> graph;
private String actorName;

BaconNumber(String actorName){
	this.graph = new HashMap<>();
	this.actorName = actorName;
}	

private void addEdges(String actor1, String actor2){
this.graph.putIfAbsent(actor1,new ArrayList<>());
this.graph.putIfAbsent(actor2,new ArrayList<>());
this.graph.get(actor1).put(actor2);
this.graph.get(actor2).put(actor1);	
}
 	private int getBaconNumber(){
		Queue<String> que = new LinkedList<>();
		Set<String> visited = new HashSet<>();
	
		que.offer(this.actorName);
		visited.add(this.actorName);
		
		int height  = 0;
		
		while(!que.isEmpty()){
			int size = que.size();
			for(int i=0;i<size;i++){
				String currActor = que.poll();
				if(currActor == “Bacon”){
					return height;
				}
				List<String> neighbour = this.graph.getOrDefault(currActor,new ArrayList<>());
				for(String actor: neighbour){
					if(!visited.contains(actor)){
						que.offer(actor);
						visited.add(actor);
					}
				}
			}
height++;	
		}
	}
}

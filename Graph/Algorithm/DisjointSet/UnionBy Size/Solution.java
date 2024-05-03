class DisjointSet{
int vertices;
private List<Integer> size;
private List<Integer> parent;

DisjointSet(int vertices){
this.vertices = vertices;
this.size = new ArrayList<>();
this.parent =  new ArrayList<>();
init();
}	

private void init(){
for(int i=0;i<this.vertices;i++){
	this.size.add(1);
	this.parent.add(i);
}	
}

private int findUltimateParent(int node){
if(node == this.parent.get(node)){
	return node;
}	
int uParent = findUltimateParent(node);
this.parent.set(node,uParent);
return uParent;
}

public void disjointUnion(int u, int v){
int uParent =  findUltimateParent(u);
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

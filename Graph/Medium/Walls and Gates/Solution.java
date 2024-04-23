practice

class Pair{
int x;
int y;

Pair(int x, int y){
	this.x =x;
	this.y =y;
}	
}
class WallsAndGates{
private int [][] grid;
private Queue<Pair> que;
private int row;
private int col;

WallsAndGates(int [][] grid){
	this.grid = grid;
	this.que = new LinkedList<>();
	if(valid()){
		this.row= grid.length;
		this.col =grid[0].length;
		init();
		bfs();
	}
}	

private boolean valid(){
if(this.grid == null || this.grid.length == 0 || this.grid[0].length == 0){
	return false;
}
return true;
}
private void init(){
for(int r= 0;r<this.row;r++){
	for(int c= 0;c<this.col;c++){
		if(this.grid[r][c] == 0){
			Pair pair =new Pair(r,c);
			this.que.offer(pair);
		}
	}
}	

}
private void bfs(){
if(this.que.isEmpty()){
return;
}
List<Pair> directions = Arrays.asList(
	new Pair(-1,0),
	new Pair(0,-1),
	new Pair(1,0),
	new Pair(0,1)
);	
		int distance = 1;
		while(!this.que.isEmpty()){
			int size = this.que.size();
			for(int i=0;i<size;i++){
				Pair curr =  this.que.poll();
				for(Pair dir : directions){
					int currX =  curr.x+dir.x;
					int currY = curr.y+dir.y;
					if(currX>=0 && currX<this.row && currY>=0 && currY<this.col && this.grid[currX][currY] == Integer.MAX_VALUE){
						this.grid[currX][currY] =  distance;
						this.que.offer(new Pair(currX,currY));
						
					}
				}
			}
			distance++;
		}
}
public int[][] getResult(){
return this.grid;	
}

}

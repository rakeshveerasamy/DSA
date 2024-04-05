class Solution {
    public int orangesRotting(int[][] grid) {
        RottenOrange ro =new RottenOrange(grid);
        return ro.getMinTimeTaken();
    }
}
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
class RottenOrange{
		private int[][] grid;
		private Queue<Pair> rottenIndex;
		private int freshOrangeCount;
		private int row;
		private int col;
		private int minTime;
		
		RottenOrange(int[][] grid){
			this.grid = grid;
			this.rottenIndex = new LinkedList<>();
			this.freshOrangeCount =0;
			this.row= grid.length;
			this.col = grid[0].length;
			this.minTime = 0;
			init();
		}	
		
		private void init(){
			for(int r =0;r<this.row;r++){
				for(int c =0;c<this.col;c++){
					if(this.grid[r][c] == 2){
						Pair pair=new Pair(r,c);
						this.rottenIndex.add(pair);
					}	
					else if (this.grid[r][c] == 1){
						this.freshOrangeCount++;
					}
				}
			}
		}
		
		public int getMinTimeTaken(){
			bfs();	
			return (this.freshOrangeCount==0)?this.minTime:-1;
		}
		private void bfs(){
			
			List<Pair> directions = Arrays.asList(
						new Pair(0,1),
						new Pair(1,0),
						new Pair(-1,0),
						new Pair(0,-1)
						);
			
			while(!this.rottenIndex.isEmpty()&& this.freshOrangeCount>0){
				int size =this.rottenIndex.size();
				
				for(int i=0;i<size;i++) {
					Pair curr = this.rottenIndex.poll();
					
					for(Pair dirr: directions){
						int currX = curr.x+dirr.x;
						int currY = curr.y+dirr.y;
						
						if(currX>=0 && currX<this.row && currY>=0 && currY<this.col && this.grid[currX][currY] == 1) {
							this.grid[currX][currY] = 2;
							this.freshOrangeCount--;
							this.rottenIndex.offer(new Pair(currX,currY));
						}
					}
				}
				
				if(!this.rottenIndex.isEmpty()){
					this.minTime++;	
				}
			}	
	  }
	
}


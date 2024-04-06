class Solution {
    public int[][] updateMatrix(int[][] mat) {
        NearestOne no = new NearestOne(mat);
        return no.getResult();
    }
}
class Pair{
	int x;
	int y;
	int distance;
	Pair(int x, int y){
		this.x =x;
		this.y =y;
		this.distance =0;
	}
	Pair(int x,int y,int distance){
		this.x =x;
		this.y =y;
		this.distance=distance;
	}
}
class NearestOne{
	private int [][] mat;
	private int rowLen;
	private int colLen;
	private int[][] result;
	private Queue<Pair> tracker;
	
	NearestOne(int [][] mat){
		this.mat = mat;
		this.rowLen = mat.length;
		this.colLen = mat[0].length;
		this.result = new int [this.rowLen][this.colLen];
		this.tracker = new LinkedList<Pair>();
		init();
	}

	private void init(){
		for(int i=0;i<this.rowLen;i++){
			Arrays.fill(this.result[i],-1);
		}
		for(int i =0;i<this.rowLen;i++){
			for(int j =0;j<this.colLen;j++){
				if(this.mat[i][j] ==  0){
					this.tracker.add(new Pair(i,j));
					this.result[i][j] = 0;
				}
			}
		}
		bfs();
	}
	private void bfs(){
		List<Pair> directions = Arrays.asList(
						new Pair(1,0),
						new Pair(0,1),
						new Pair(0,-1),
						new Pair(-1,0)
						);
	
		while(!this.tracker.isEmpty()){
			Pair curr = this.tracker.poll();
			for(Pair dirr:directions){
				int currX = curr.x+dirr.x;
				int currY = curr.y+dirr.y;
				if(currX>=0 && currX<this.rowLen && currY>=0 && currY<this.colLen && this.result[currX][currY] ==-1 && this.mat[currX][currY] == 1){
					this.tracker.offer(new Pair(currX,currY, curr.distance+1));
					this.result[currX][currY] = curr.distance+1;
				}
			}
		}
	}
	public int[][] getResult(){
		return this.result;
	}
	
}	

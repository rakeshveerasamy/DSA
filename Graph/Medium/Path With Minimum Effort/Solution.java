/*
    Time complexity - (row*col*4 log(row*col)); 
        dijikstra algorithm time complexity (V+E (logV))
        V = row*col
        E= row*col*4

    Space complexity - row*col
*/


class Solution {
    public int minimumEffortPath(int[][] heights) {
        MinTime mt = new MinTime(heights);
        return mt.getResult();
    }
}
class Node{

int src;
int des;
int distance;

Node(int src,int des, int distance){
	this.src = src;
	this.des =des;
	this.distance =distance;
}	
}
class MinTime{
	private int [][] heights;
	private int row;
	private int col;
	private int [][] time;

	MinTime(int[][] heights){
		this.heights = heights;
		
		if(isValid()){
			this.row = heights.length;
			this.col = heights[0].length;
			this.time = new int [this.row][this.col];
			init();
			findMinTime();
		}
	}
	
	private boolean isValid(){
		return this.heights!=null && this.heights.length!=0 && this.heights[0].length!=0;
	}
		
	private void init(){
		for(int i=0;i<this.row;i++){
			Arrays.fill(this.time[i],Integer.MAX_VALUE);
		}
	}
	
	private void findMinTime(){
		PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> (x.distance-y.distance));
		pq.add(new Node(0,0,0));
		this.time[0][0] = 0;
		int dirRow [] =  new int []{-1,0,1,0};
		int dirCol[] = new int []{0,-1,0,1};
		
		while(!pq.isEmpty()){
			Node curr = pq.poll();
			
			if(curr.src == this.row-1 && curr.des ==this.col-1){
				return;	
			}
			
			for(int i=0;i<4;i++){
				int currR = curr.src+dirRow[i];
				int currC = curr.des+dirCol[i];
				if(valid(currR,currC)){
				int distance = Math.max(Math.abs(this.heights[curr.src][curr.des] - this.heights[currR][currC]) , curr.distance);
			
				if(this.time[currR][currC]>distance){
					this.time[currR][currC] = distance;
					pq.offer(new Node(currR,currC,distance));
				}
				}
			}

		}
	}
	
	private boolean valid(int x, int y){
		return x>=0 && y>=0 && x<this.row &&y<this.col;	
	}
	
	public int getResult(){
		return ( this.time!=null)? this.time[this.row-1][this.col-1]:-1;
	}

}

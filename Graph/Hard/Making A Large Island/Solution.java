class Solution {
    public int largestIsland(int[][] grid) {
        LargestIsland li= new LargestIsland(grid);
        return li.getResult();
    }
}
class DisjointSet {
	private int vertices;
	private List<Integer> parent;
	List<Integer> size;

	DisjointSet(int vertices) {
		this.vertices = vertices;
		this.parent = new ArrayList<>();
		this.size = new ArrayList<>();
		init();
	}

	private void init() {

		for (int i = 0; i < this.vertices; i++) {
			this.parent.add(i);
			this.size.add(1);
		}
	}

	public int findUltimateParent(int node) {

		if (this.parent.get(node) == node) {
			return node;
		}

		int par = findUltimateParent(this.parent.get(node));
		this.parent.set(node, par);
		return par;
	}

	public void unionBySize(int u, int v) {

		int uParent = findUltimateParent(u);
		int vParent = findUltimateParent(v);

		if (uParent == vParent)
			return;

		if (this.size.get(uParent) < this.size.get(vParent)) {
			this.parent.set(uParent, vParent);
			this.size.set(vParent, this.size.get(uParent) + this.size.get(vParent));
		} else {
			this.parent.set(vParent, uParent);
			this.size.set(uParent, this.size.get(uParent) + this.size.get(vParent));
		}
	}
}

class LargestIsland {
	private int[][] grid;
	private int row;
	private int col;
	private int maxCount;

	LargestIsland(int [][] grid){
			this.grid = grid;
			this.maxCount = 0;
			
			if(isValid()){
				this.row = grid.length;
				this.col = grid[0].length;
				findMaxCount();
			}
		}

	private boolean isValid() {
		return this.grid != null && this.grid.length != 0 && this.grid[0].length != 0;
	}

	private boolean inLimit(int r, int c) {
		return r >= 0 && c >= 0 && r < this.row && c < this.col;
	}

	private void findMaxCount(){
			DisjointSet set =  new DisjointSet(this.row* this.col);
			int [] rDir = new int []{-1,0,1,0};
			int [] cDir = new int[]{0,-1,0,1};

			
			for(int i=0;i<this.row;i++){
				for(int j=0;j<this.col;j++){
				
				if(this.grid[i][j] == 0) continue;
				
				for(int ind = 0;ind<4;ind++){
					int currRow = i+rDir[ind];
					int currCol = j+cDir[ind];
			
					if(inLimit(currRow,currCol) && this.grid[currRow][currCol] ==1){
						int node = (i* this.col) + j;
						int currNode = (currRow*this.col) +currCol;
						set.unionBySize(node,currNode);
					}
				}
}	
			}


			//step 2;
			
			int max =0;
			for(int i=0;i<this.row;i++){
				for(int j=0;j<this.col;j++){
					if(this.grid[i][j] ==1) continue;
					HashSet<Integer> component =  new HashSet<Integer>();
					
					for(int ind = 0;ind<4;ind++){
						int currRow=  i+rDir[ind];
						int currCol = j+cDir[ind];
						
						if(inLimit(currRow,currCol) && this.grid[currRow][currCol] ==1){
							component.add(set.findUltimateParent((currRow*this.col)+currCol));
						}
					}
					int totalSize = 0;
					for(Integer value: component){	
						totalSize+=set.size.get(value);
					}
					max = Math.max(max,totalSize+1);
					
				}
			}

			this.maxCount =max;
            System.out.println(max);
			for(int cell = 0 ;cell<this.row*this.col;cell++){
                this.maxCount = Math.max(this.maxCount , set.size.get(set.findUltimateParent(cell)));
            }
		}

	public int getResult() {
		return this.maxCount;
	}

}

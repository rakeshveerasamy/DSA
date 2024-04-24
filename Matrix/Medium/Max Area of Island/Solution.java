class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        MaxArea ma = new MaxArea(grid);
        return ma.getResult();
    }
}

class MaxArea{
    private int [][] grid;
    private int row;
    private int col;
    private int maxArea;
        
    MaxArea(int [][] grid){
        this.grid = grid;
        this.maxArea = 0;
        if(isValid()){
                
            this.row = grid.length;
            this.col = grid[0].length;
            
            findMaxArea();
        }
    }

    private boolean isValid(){
            
        return this.grid!=null && this.grid.length!=0 && this.grid[0].length!=0;
    }
    private int  dfs(int r, int c){
        int area = 0;
        if(r>=0 && r<this.row && c>=0 && c<this.col && this.grid[r][c] == 1){
        	area  = 1;
            this.grid[r][c] = 0;
            area+=dfs(r-1,c);
            area+=dfs(r,c-1);
            area+=dfs(r+1,c);
            area+=dfs(r,c+1);
        }
        return area;
    }
    private void findMaxArea(){
            for(int i=0;i<this.row;i++){
                    for(int j = 0;j<this.col;j++){
                            if(this.grid[i][j] == 1){                                    
                                    this.maxArea =Math.max(dfs(i,j),this.maxArea);
                            }
                    }
            }
    }
    public int getResult(){
            return this.maxArea;
    }
}

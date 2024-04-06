class Solution {
    public int numEnclaves(int[][] grid) {
        NumberOfEnclave noe = new NumberOfEnclave(grid);
        return noe.getResult();
    }
}
class NumberOfEnclave{
    private int[][] grid;
    private int rowLen;
    private int colLen;
    private int moveCount;
        
    NumberOfEnclave(int[][] grid){
        this.grid = grid;
        this.rowLen=grid.length;
        this.colLen=grid[0].length;
        this.moveCount =0;
        init();
    }
    
    private void init(){
            for(int i=0;i<this.rowLen;i++){
                if(this.grid[i][this.colLen-1]==1){
                    dfs(i,colLen-1);
                }
                if(this.grid[i][0]==1){
                    dfs(i,0);
                }
            }
            for(int i=0;i<this.colLen;i++){
                if(this.grid[this.rowLen-1][i]==1){
                    dfs(rowLen-1,i);
                }
                if(this.grid[0][i]==1){
                    dfs(0,i);
                }
            }
            countMoves();
    }
    private void countMoves(){
            for(int i=0;i<this.rowLen;i++){
                for(int j=0;j<this.colLen;j++){
                        if(this.grid[i][j] == 1){
                                this.moveCount++;
                        }
                }
            }
    }
    public int getResult(){
        return this.moveCount;
    }
    
    private void dfs(int row, int col){
            if(row>=0 && col>=0 && row<this.rowLen && col<this.colLen && this.grid[row][col] == 1){
                this.grid[row][col] = -1;
                dfs(row-1,col);
                dfs(row,col-1);
                dfs(row,col+1);
                dfs(row+1,col);
            }
    }
    
}

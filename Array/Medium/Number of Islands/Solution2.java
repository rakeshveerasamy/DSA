class Solution {
    public int numIslands(char[][] grid) {
        NumberOfIsland noi = new NumberOfIsland(grid);
        return noi.getResult();
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class NumberOfIsland{
    private char[][] grid;
    private int row;
    private int col;
    private int count;

    NumberOfIsland(char [][] grid){
            this.grid = grid;
            this.count =0;

            if(isValid()){
                this.row = grid.length;
                this.col = grid[0].length;
                countIsland();
            }
    }

    private boolean isValid(){
        return this.grid!=null && this.grid.length!=0 && this.grid[0].length!=0;
    }

    private void countIsland(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.grid[i][j] == '1'){
                    performDFS(i,j);
                    this.count++;
                }
            }
        }
    }

    private boolean inLimit(int r, int c){
        return r>=0 && c>=0 && r<this.row&& c<this.col;
    }

    private void performDFS(int row,int col){
        
        if(inLimit(row,col) && this.grid[row][col] == '1'){
            this.grid[row][col] = '0';
            performDFS(row-1,col);
            performDFS(row,col-1);
            performDFS(row+1,col);
            performDFS(row,col+1);
        }
        
    }

    public int getResult(){
        return this.count;
    }
}

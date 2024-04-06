class Solution {
    public void solve(char[][] board) {
        SurroundedRegion sr = new SurroundedRegion(board);
        board = sr.getResult();
    }
}
class SurroundedRegion{
    private char[][] region;
    private int rowLen;
    private int colLen;

    SurroundedRegion(char[][] region){
        this.region = region;
        this.rowLen = region.length;
        this.colLen = region[0].length;
        init();
    }	
    private void init(){
            for(int i=0;i<this.rowLen;i++){
                if(this.region[i][this.colLen-1] =='O'){
                    dfs(i,colLen-1);
                }	
                if(this.region[i][0] == 'O'){
                    dfs(i,0);
                }
              }
            for(int i=0;i<this.colLen;i++){
                if(this.region[this.rowLen-1][i] =='O'){
                    dfs(rowLen-1,i);
                }	
                if(this.region[0][i] == 'O'){
                    dfs(0,i);
                }
            }
            markSafer();
    }
    private void markSafer(){
        for(int i= 0;i<this.rowLen;i++){
        for(int j =0;j<this.colLen;j++){
            if(this.region[i][j] == 'O'){
                this.region[i][j] = 'X';
            }
            if(this.region[i][j] == 'S'){
                this.region[i][j] = 'O';
            }
        }
    }	
    }
    public char[][] getResult(){
         return this.region;	
    }
    private  void dfs(int row,int col){
        if(row>=0 && col>=0 && row<this.rowLen && col<this.colLen && this.region[row][col] == 'O'){
            this.region[row][col] = 'S';
            dfs(row,col-1);
            dfs(row-1,col);
            dfs(row,col+1);
            dfs(row+1,col);
        }	
    }
}


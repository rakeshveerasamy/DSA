class Solution {
    public void gameOfLife(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        // 0 - > 1 =  -1
        //1 -> 0   = 2
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                
                validateState(board,i,j);
            }
        }
        updateLiveStatus(board);
    }
    private void updateLiveStatus(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 1;
                } else if (board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }
    private void validateState(int [][] board,int i , int j){
        List<Point> directions =  Arrays.asList(new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0),
                                                new Point(1,-1),new Point(-1,1),new Point(-1,-1),new Point(1,1));
        Point curr =  new Point(i,j);
        int liveCount = 0;
        for(Point dir : directions){
            int currDirrX = curr.x+dir.x;
            int currDirrY = curr.y+dir.y;
            if(currDirrX<0 || currDirrY<0 || currDirrX>=board.length || currDirrY>=board[0].length){
                continue;
            }
            if(board[currDirrX][currDirrY] == 1 || board[currDirrX][currDirrY] == 2){
                liveCount++;
            }
        }
        if(board[i][j] == 0  && liveCount ==  3){
            board[i][j] = -1;
        }
        else if (board[i][j] == 1 &&(liveCount<2 || liveCount>3)){
            board[i][j] = 2;
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x , int y){
        this.x =x;
        this.y=y;
    }
}

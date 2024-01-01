import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Solution {
    public static int solution(int[][] map) {
        // Your code here
        Station station= new Station(map);
        int startBoard[][] = station.getPoints(0,0);
        int endBoard[][] = station.getPoints(station.height-1,station.width-1);
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<station.height;i++){
            for(int j= 0;j<station.width;j++){
                if(startBoard[i][j]>0 && endBoard[i][j]>0){
                    res = Math.min(startBoard[i][j]+endBoard[i][j]-1,res);
                }
            }
        }
        return res;
    }
}
class Point {
    int x;
    int y;
    Point (int x , int y){
        this.x = x;
        this.y = y;
    }
}
class Station {
    int [][] map;
    int height;
    int width;
    Station (int [][] map){
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;
    }
    
    protected int[][] getPoints(int sx,int sy){
        int [][] board = new int [this.height][this.width];
        for(int i= 0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                board[i][j] = -1;
            }
        }
        board[sx][sy] = 1;
        
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(sx,sy));
        
        List<Point> directions = Arrays.asList(
            new Point(1,0),
            new Point(-1,0),
            new Point(0,1),
            new Point(0,-1)
        );
        
        while(!points.isEmpty()){
            Point p = points.remove(0);
            for(Point d:directions){
                int nx =p.x+d.x;
                int ny =p.y+d.y;
                if(nx>=0 && nx<this.height && ny>=0 && ny<this.width){
                    if(board[nx][ny] == -1){
                        board[nx][ny] = board[p.x][p.y]+1;
                        if(this.map[nx][ny] == 1)continue;
                        points.add(new Point(nx,ny));
                    }
                }
            }
        }
        return board;
    }
}

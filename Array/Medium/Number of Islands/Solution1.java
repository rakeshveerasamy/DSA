//TIme Complexity -  O(n+M) = n = no of cells and M= no of edges
//Space complexity = O(n) = n = number of cells

class Solution {
    
    public int numIslands(char[][] grid) {
        IslandCount count = new IslandCount(grid);
        return count.countNoOfIsland();
    }
}
class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class IslandCount{
        char [][] grid;
        int height;
        int width;
        IslandCount(char [][]grid) {
            this.grid = grid;
            this.height = grid.length;
            this.width  = grid[0].length;
        }
        public int countNoOfIsland(){
            int noOfIsland = 0;
            for(int i = 0;i<this.height;i++){
                for(int j= 0;j<this.width;j++){
                    if((this.grid[i][j]) == '1'){
                        trackIsland(i,j);
                        noOfIsland++;
                    }
                }
            }
            return noOfIsland;
        }
        private void trackIsland(int x,int y){
            List<Point> points = new ArrayList<>();
            points.add(new Point(x,y));

            List<Point> directions = Arrays.asList(
                new Point(0,1),
                new Point(0,-1),
                new Point(-1,0),
                new Point(1,0)
            );

            while(!points.isEmpty()){
                Point s = points.remove(0);
                for(Point d: directions){
                    int cx = s.x+d.x;
                    int cy = s.y+d.y;
                    if(cx>=0 && cx<this.height && cy>=0 && cy<this.width && (this.grid[cx][cy])=='1'){
                        points.add(new Point(cx,cy));
                        this.grid[cx][cy] = '0';
                    }
                }
            }
        }
}

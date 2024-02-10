class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        	FloodFill floodFill = new FloodFill(image,sr,sc,color);
            return floodFill.foodFill();
    }
}

class FloodFill{
    private int [][] image;
    private int height;
    private int width;
    private int prevColor;
    private int currentColor;
    private int sr;
    private int sc;

    FloodFill(int [][]image , int sr, int sc,int color){
        this.image = image;
        this.height = image.length;
        this.width = image[0].length;
        this.prevColor = image[sr][sc];
        this.currentColor = color;
        this.sr = sr;
        this.sc = sc;
    }	
    public int[][] foodFill(){
        if(this.prevColor!=this.currentColor){
            dfs(sr,sc);
        }
        return this.image;
    }
    private void dfs(int sr , int sc){
        if(sr>=0 && sr<this.height&&sc>=0 && sc<this.width && this.image[sr][sc] == this.prevColor){

            this.image[sr][sc] = this.currentColor;
            dfs(sr,sc-1);
            dfs(sr,sc+1);
            dfs(sr-1,sc);
            dfs(sr+1,sc);
         }

    }

}

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        NinjaTraining nt=new NinjaTraining(points,n);
        return nt.getResult();
    }

}
class NinjaTraining{
    private int [][] points;
    private int n;
    private int row;
    private int col;
    private int maxPoints;


    NinjaTraining(int [][] points, int n){
        this.points = points;
        this.n  = n;
        this.row = points.length;
        this.col = points[0].length;
        this.maxPoints = Integer.MIN_VALUE;
        findMaximumMerit();
    }

    private void findMaximumMerit(){
        int dp[][] = new int [this.n][4];
        dp[0][0] = Math.max(this.points[0][1],this.points[0][2]);
        dp[0][1] = Math.max(this.points[0][0],this.points[0][2]);
        dp[0][2] = Math.max(this.points[0][0],this.points[0][1]);
        dp[0][3] = Math.max(this.points[0][0],Math.max(this.points[0][1],this.points[0][2]));


        for(int i =1;i<this.n;i++){
            for(int last = 0;last<4;last++){
                dp[i][last] = 0;

                for(int task = 0;task<=2;task++){
                    if(task!=last){
                       int  meritPoint = this.points[i][task]+dp[i-1][task];
                        dp[i][last] = Math.max(meritPoint,dp[i][last]);
                    }
                }
            }
        }
        this.maxPoints = dp[this.n-1][3];
    }
    public int getResult(){
        return this.maxPoints;
    }
}

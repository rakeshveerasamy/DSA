import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int row = triangle.length;
        int [][] dp = new int [row][row];

        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }

        return findMin(dp,triangle, 0, 0);
    }
    private static int findMin(int[][] dp, int [][] triangle, int row,int col){
            if(row>=triangle.length || col>row){
                return 0;
            }

            if(dp[row][col]!=-1) return dp[row][col];

            dp[row][col] = Math.min(findMin(dp,triangle,row+1,col),findMin(dp,triangle,row+1,col+1))+triangle[row][col];

            return dp[row][col];
    }
}

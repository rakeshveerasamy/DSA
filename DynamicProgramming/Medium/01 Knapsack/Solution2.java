import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            Knapsack ks = new Knapsack(weight, value,n,maxWeight);
            return ks.getResult();

    }
}


class Knapsack{
    private int [] weight;
    private int [] value;
    private int n;
    private int maxWeight;
    private int totalValue;

    Knapsack(int [] weight, int [] value, int n , int maxWeight){
        this.weight = weight;
        this.value = value;
        this.n = n;
        this.maxWeight = maxWeight;
        this.totalValue = 0;

        if(isValid()){
                findMaximumValue();      
        }
    }

    private boolean isValid(){
            return this.weight!=null && this.value!=null && this.n!=0 && this.maxWeight!=0 
            && this.weight.length == this.value.length && this.weight.length ==this.n;
    }
    private void findMaximumValue(){
        int [][] dp = new int [this.n][this.maxWeight+1];

       for(int i = this.weight[0];i<=this.maxWeight;i++){
           dp[0][i] = this.value[0];
       }

       for(int i=1;i<this.n;i++){
           for(int j = 0;j<=this.maxWeight;j++){
               int notTake = dp[i-1][j];
               int take = Integer.MIN_VALUE;

               if(this.weight[i]<=j){
                   take = this.value[i]+dp[i-1][j-this.weight[i]];
               }
                dp[i][j] = Math.max(take,notTake);

           }
       }

       this.totalValue = dp[this.n-1][this.maxWeight];
    }
   
    public int getResult(){
        return this.totalValue;
    }
}

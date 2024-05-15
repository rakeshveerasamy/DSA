import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
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

            for(int [] row: dp){
                Arrays.fill(row,-1);
            }
            this.totalValue = findMaximumValueHelper(this.n-1,this.maxWeight,dp);
    }

    private int findMaximumValueHelper(int index, int maxWeight, int [][] dp){
    
        if(index<0){
            return 0;
        }

        if(dp[index][maxWeight]!=-1){
            return dp[index][maxWeight];
        }
        if(index == 0){
            if(maxWeight>=this.weight[index]){
                return this.value[index];
            }
            return 0;
        }

        int notTake = 0+ findMaximumValueHelper(index-1,maxWeight,dp);
        int take = Integer.MIN_VALUE;
        if(this.weight[index]<=maxWeight){
            take = this.value[index]+ findMaximumValueHelper(index-1,maxWeight -this.weight[index],dp);
        }

        return  dp[index][maxWeight] = Math.max(notTake,take);
    }

    public int getResult(){
        return this.totalValue;
    }
}

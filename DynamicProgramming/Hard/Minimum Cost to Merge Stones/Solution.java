class Solution {
    public int mergeStones(int[] stones, int k) {
       MergeStones ms =new MergeStones(stones, k);
       return ms.getResult();
        
//         int n = stones.length;
//         if ((n - 1) % (k - 1) != 0) {
//             return -1;
//         }

//         int[] prefixSum = new int[n + 1];
//         for (int i = 0; i < n; i++) {
//             prefixSum[i + 1] = prefixSum[i] + stones[i];
//         }

//         int[][] dp = new int[n][n];
//         for (int len = k; len <= n; len++) {
//             for (int i = 0; i + len <= n; i++) {
//                 int j = i + len - 1;
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for (int m = i; m < j; m += k - 1) {
//                     dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
//                 }
//                 if ((len - 1) % (k - 1) == 0) {
//                     dp[i][j] += prefixSum[j + 1] - prefixSum[i];
//                 }
//             }
//         }

//         return dp[0][n - 1];
    }
}

class MergeStones{
        private int [] stones;
        private int k;
        private int minCost;
        
        MergeStones(int [] stones, int k){
            this.stones = stones;
            this.k = k;
            this.minCost = -1;
            
            if(isValid()){
               findMinCost(); 
            }
        }
    
        private boolean isValid(){
            return this.stones!=null && this.stones.length!=0 ;
        }
    
        private void findMinCost(){
                
                int size = this.stones.length;
            
                if(size == 1){
                    this.minCost = 0;
                    return;
                }
                
                if((size-1) %(this.k-1)!=0){
                    return;
                }
                
                int [] prefix = new int [size+1];
                int [][] dp = new int [size][size];
                for(int i=0;i<size;i++){
                    prefix[i+1]  = prefix[i]+this.stones[i];
                }
            
                for(int len = this.k;len<=size;len++){
                    for(int i= 0;i+len<=size;i++){
                        int j = i+len-1;
                        
                        dp[i][j] =Integer.MAX_VALUE;
                            
                        for(int m = i;m<j;m+=this.k-1){
                            dp[i][j] = Math.min(dp[i][j],dp[i][m]+dp[m+1][j]);
                        }
                        
                        if((len-1)%(this.k-1) == 0){
                             dp[i][j]+=prefix[j+1]-prefix[i];
                         }   
                    }
                    
                    
                }
            this.minCost = dp[0][size-1];
        }
    
    public int getResult(){
        return this.minCost;
    }
}

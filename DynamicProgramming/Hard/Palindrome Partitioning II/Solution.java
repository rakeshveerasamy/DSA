class Solution {
    public int minCut(String s) {
        PalindromePartitioning pp = new PalindromePartitioning(s);
        return pp.getMinCost();
    }
}
class PalindromePartitioning{
private String s;
private int len;
private boolean [][] dp;
private int [] cost;

PalindromePartitioning(String s){
	this.s =s;
	this.len =s.length();
	this.dp = new boolean[this.len][this.len];
	this.cost = new int [this.len];
}	

public int getMinCost(){
	for(int i = 0;i<this.len;i++){
		this.cost[i]=i;
		for(int j = 0;j<=i;j++){
			if(this.s.charAt(j) == this.s.charAt(i) && (i-j<=1 || this.dp[j+1][i-1])){
				dp[j][i] = true;
				this.cost[i] = (j==0)?0:Math.min(this.cost[i],this.cost[j-1]+1);
			}
		}
	}
	return this.cost[this.len-1];
}
}

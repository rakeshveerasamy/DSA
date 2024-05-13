class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        ShortestCommonSupersequence scss = new ShortestCommonSupersequence(str1,str2);
        return scss.getResult();
    }
}
class ShortestCommonSupersequence{
	private String str1;
	private String str2;
	private int str1Len;
	private int str2Len;
	private String res;
	
	ShortestCommonSupersequence(String str1,String str2){
		this.str1 = str1;
		this.str2 = str2;
		this.res = "";
			
		if(isValid()){
			this.str1Len = str1.length();
			this.str2Len =  str2.length();
			findShortestSupersequence();
		}
	}	
	
	private boolean isValid(){
		return this.str1!=null && this.str2!=null && this.str1.length()!=0 && this.str2.length()!=0;
	}	

	private void findShortestSupersequence(){
		int [][] dp = new int [this.str1Len+1][this.str2Len+1];
		
		for(int i=1;i<=this.str1Len;i++){
			for(int j =1;j<=this.str2Len;j++){
				if(this.str1.charAt(i-1) == this.str2.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
	
		int i =this.str1Len;
		int j = this.str2Len;
		
		while(i>0 && j>0){
			if(this.str1.charAt(i-1) == this.str2.charAt(j-1)){
				this.res+=str1.charAt(i-1);
				i--;
				j--;
			}
			else if (dp[i-1][j]>dp[i][j-1]){
				this.res+=this.str1.charAt(i-1);
				i--;
			}	
			else{
				this.res+=this.str2.charAt(j-1);
				j--;
			}
		}	
	
		while(i>0){
			this.res+=this.str1.charAt(i-1);
			i--;
		}
		while(j>0){
			this.res+=this.str2.charAt(j-1);
			j--;	
		}
	
		this.res = new StringBuilder(this.res).reverse().toString();
	}	
	
	public String getResult(){
		return this.res;	
	}
}	

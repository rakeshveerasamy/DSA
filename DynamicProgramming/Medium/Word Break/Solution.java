class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        WordBreak wb= new WordBreak(s,wordDict);
        return wb.canSegment();
    }
}
class WordBreak{
	private String word;
	private int size;
	private Set<String> dict;
	
	WordBreak(String word,List<String> dictList){
		this.word =word;
		this.size = word.length();
		this.dict = new HashSet<>(dictList);
	}

public boolean canSegment(){
    boolean dp[] =  new boolean [this.size+1];
    dp[0] = true;
    for(int i = 1;i<=size;i++){
                for(int j=0;j<i;j++){
                        if(dp[j] && this.dict.contains(this.word.substring(j,i))){
                            dp[i] = true;
                            break;
                        }
                }
        }
    return dp[this.size];
}
	
	
}

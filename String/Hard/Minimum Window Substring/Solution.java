class Solution {
    public String minWindow(String s, String t) {
        MinimumSlidingSubstring mss = new MinimumSlidingSubstring(s,t);
        return mss.findMinimumSliding();
    }
}
class MinimumSlidingSubstring{
	private String word;
	private String target;
	private HashMap<Character,Integer> targetMap;
	private HashMap<Character,Integer> windowMap;
	
	MinimumSlidingSubstring(String word,String target){
		this.word = word;
		this.target = target;
		this.targetMap =  new HashMap<>();
		this.windowMap = new HashMap<>();
		init();
	}	
	
	private void init(){
		for(Character ch : this.target.toCharArray()){
			this.targetMap.put(ch,targetMap.getOrDefault(ch,0)+1);
		}	
		
	}	
	public String findMinimumSliding(){
		int minStart = -1;
		int minLen = Integer.MAX_VALUE;
		int requiredSize = this.targetMap.size();
		int formed = 0;
		int left = 0;
		int right=0;
		
		while(right<this.word.length()){
			char currChar =  this.word.charAt(right);
			this.windowMap.put(currChar,this.windowMap.getOrDefault(currChar,0)+1);
			if(this.targetMap.containsKey(currChar) && this.targetMap.get(currChar).equals(this.windowMap.get(currChar))){
				formed++;
			}
			while(left<=right && formed == requiredSize){
				int windowSize = right-left+1;
				
				if(windowSize<minLen){
				 	minLen =windowSize;		
					minStart=left;
				}
				
				char leftChar = this.word.charAt(left);
				this.windowMap.put(leftChar,this.windowMap.getOrDefault(leftChar,0)-1);
                
				if(this.targetMap.containsKey(leftChar) && this.windowMap.get(leftChar) < this.targetMap.get(leftChar)){
					formed--;
				}
				left++;
			}
			right++;
		}
		return minStart == -1? "": this.word.substring(minStart,minStart+minLen);
	}
	
}

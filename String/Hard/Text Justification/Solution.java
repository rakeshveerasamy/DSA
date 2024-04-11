class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        TextJustification tj = new TextJustification(words,maxWidth);
        return tj.getResult();
    }
}
class TextJustification{
	private String [] words;
	private int size;
	private List<String> justifiedText;
	private int maxWidth;
	
	TextJustification(String [] words,int maxWidth){
		this.words = words;
		this.size = words.length;
		this.maxWidth = maxWidth;
		this.justifiedText =  new ArrayList<>();
		textJustification();
	}	
	
	private void textJustification(){
		int index = 0;
		while(index<this.size){
		List<String> currentJustifiedWords = new ArrayList<>();
		currentJustifiedWords.add(this.words[index]);
			int currentJustifiedTextLen = this.words[index].length();
			index++;
			
			while(index<this.size && currentJustifiedTextLen+1+this.words[index].length()<=this.maxWidth){
				currentJustifiedTextLen+=1+this.words[index].length();
				currentJustifiedWords.add(this.words[index++]);
			}
			
			if(index == this.size || currentJustifiedWords.size() == 1){
				String leftJustified = String.join(" ",currentJustifiedWords);

				int spaceCount= this.maxWidth - leftJustified.length();
				String rightSpace = " ".repeat(spaceCount);
				this.justifiedText.add(leftJustified+rightSpace);
				continue;
			}	
				
			int totalSpace = this.maxWidth - (currentJustifiedTextLen - currentJustifiedWords.size()+1);
			int spaceWidth = totalSpace/(currentJustifiedWords.size()-1);
			int extraSpace =totalSpace%(currentJustifiedWords.size()-1);
			
			StringBuilder justifiedWord = new StringBuilder();
			for(int wordIndex = 0;wordIndex<currentJustifiedWords.size()-1;wordIndex++){
				justifiedWord.append(currentJustifiedWords.get(wordIndex));
				justifiedWord.append(" ".repeat(spaceWidth));
				if(wordIndex<extraSpace){
					justifiedWord.append(" ");
				}
				
			}
		
			justifiedWord.append(currentJustifiedWords.get(currentJustifiedWords.size()-1));
			this.justifiedText.add(new String(justifiedWord));
		}	
	}
	
	public List<String> getResult(){
	return this.justifiedText;	
	}
		

}

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        WordLadder wl = new WordLadder(beginWord,endWord,wordList);
        return wl.getResult();
    }
}
class WordLadder{
	private String beginWord;
	private String endWord;
	private Set<String> wordSet;
	private HashMap<String , Integer> stepMap;
	private List<List<String>> result;
	private Queue<String> que;

	WordLadder(String beginWord,String endWord,List<String> wordList){
		this.wordSet = new HashSet<>(wordList);
		this.beginWord = beginWord;
		this.endWord = endWord;
		this.stepMap = new HashMap<>();
		this.result = new ArrayList<>();
		this.que = new LinkedList<>();
		init();
	}	

	private void init(){
		if(!this.wordSet.contains(this.endWord)){
			return;
		}
		this.que.offer(this.beginWord);
		this.stepMap.put(this.beginWord,0);
		this.wordSet.remove(this.beginWord);
		bfs();
	}
	private void bfs(){
		while(!this.que.isEmpty()){
			String currWord = this.que.poll();
			int size = currWord.length();
			int step = this.stepMap.get(currWord);
			
			if(currWord.equals(this.endWord)) break;
			for(int i=0;i<size;i++){
			        for(char ch ='a' ; ch<='z';ch++){
						char [] currChar = currWord.toCharArray();
						currChar[i] = ch;
						String replacedWord = new String(currChar);
						
						if(this.wordSet.contains(replacedWord)){
							this.que.offer(replacedWord);
							this.wordSet.remove(replacedWord);
							this.stepMap.put(replacedWord,step+1);
						}
				}
				
			}
		
		}
		if(this.stepMap.containsKey(this.endWord)){
		List<String> seq = new ArrayList<>();
		seq.add(this.endWord);
		dfs(this.endWord,seq);	
		
		}
		
	}
private void dfs(String word, List<String> seq){
	
	if(word.equals(this.beginWord)){
		List<String> res = new ArrayList<>(seq);
		Collections.reverse(res);
		this.result.add(res);
		return;
	}
	int size = word.length();
	int step = this.stepMap.get(word);
	for(int i=0;i<size;i++){
		for(char ch ='a';ch<='z';ch++){
			char currWord[] =  word.toCharArray();
			currWord[i] = ch;
			String replacedWord = new String(currWord);
			if(this.stepMap.containsKey(replacedWord) && this.stepMap.get(replacedWord)+1==step){
				seq.add(replacedWord);	
				dfs(replacedWord,seq);
				seq.remove(seq.size()-1);
			}
		}
	}
}
    public List<List<String>> getResult(){
            return this.result;
    }
}

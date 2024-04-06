class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        WordLadder wl = new WordLadder(beginWord,endWord,wordList);
        return wl.findMinStep();
    }
}

class Pair{
	int step;
	String word;
	Pair(String word,int step){
		this.word =word;
		this.step =step;
	}
}
class WordLadder{
    private List<String> wordList;
    private String beginWord;
    private String endWord;
    private Set<String> wordSet;
    private Queue<Pair> wordQueue;


    WordLadder(String beginWord, String endWord,List<String> wordList){
        this.beginWord =beginWord;
        this.endWord = endWord;
        this.wordList = wordList;
        this.wordSet = new HashSet<>();
        this.wordQueue = new LinkedList<>();
        init();
    }	

    private void init(){
        for(String word: this.wordList){
            this.wordSet.add(word);	
        }
    }
    public  int findMinStep(){

        this.wordQueue.offer(new Pair(this.beginWord,1));
        this.wordSet.remove(this.beginWord);

        while(!this.wordQueue.isEmpty()){
            Pair curr =  this.wordQueue.poll();
            if((curr.word).equals(this.endWord)){
                return curr.step;
            }
            for(int i = 0;i<(curr.word).length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] currChar = (curr.word).toCharArray();
                    currChar[i] = ch;
                    String replacedWord = new String(currChar);
                    if(this.wordSet.contains(replacedWord)){
                        this.wordSet.remove(replacedWord);
                        this.wordQueue.offer(new Pair(replacedWord,curr.step+1));
                    }
                }
            }
        }
        return 0;
    }

}

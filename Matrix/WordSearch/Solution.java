class Solution {
    public boolean exist(char[][] board, String word) {
        WordSearch ws =  new WordSearch(board,word);
        return ws.search();
            
    }
}
class WordSearch{
	private char[][] board;
	private String word;
	private int height;
	private int width;
	private boolean [][] visited;
	WordSearch(char[][] board, String word){
		this.board = board;
		this.word = word;
		this.height = board.length;
		this.width = board[0].length;
		this.visited  = new boolean[this.height][this.width];
		
	}
	public boolean search() {
		for(int i = 0;i<this.height;i++) {
			for(int j = 0;j<this.width;j++) {
				if(exists(i,j,0)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean exists(int x,int y, int index) {
		if(index == this.word.length()) {
			return true;
		}
		if(x<0 || y<0 || x>=this.height || y>=this.width||  this.visited[x][y] || this.word.charAt(index)!=this.board[x][y]) {
			return false;
		}
		this.visited[x][y] = true;
		boolean found = exists(x-1,y,index+1) || exists(x,y-1,index+1) || exists(x+1,y,index+1) || exists(x,y+1,index+1);
        this.visited[x][y] =  false;
		return found;
	}
}

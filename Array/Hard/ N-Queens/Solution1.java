class Solution {
    public List<List<String>> solveNQueens(int n) {
        return queenSolve(n);
    }
    private List<List<String>> queenSolve(int n) {
		List<List<String>> solution =  new ArrayList<>();
		char [][] board = new char[n][n];
		for(int i = 0;i<n;i++){
			Arrays.fill(board[i] , '.');	
		}
		queenSolveHelper(solution , board , 0 ,n);
		return solution;
	}
	private void queenSolveHelper(List<List<String>> solution , char [][]  board , int row , int size){
		if(row == size) {
	solution.add(constructSolution(board));
	return;
}	
for(int col = 0;col<size;col++){
	if(isValidEntry(board ,row,col,size)){
		board[row][col] = 'Q';
		queenSolveHelper(solution , board, row+1,size);
		board[row][col] = '.';
	}
}
	}
	private boolean isValidEntry(char [][] board, int row, int col, int size) {
		for(int i = 0 ;i<size;i++){
			if(board[i][col] == 'Q') return false; 	
		}
		//Left diagonal
		for(int  i =row-1,j=col-1; i>=0 && j>=0 ; i--,j--) {
			if(board[i][j] == 'Q') return false;
		}
		for(int i = row - 1,j=col+1;i>=0 &&j<size;i--,j++) {
			if(board[i][j] == 'Q') return false;
		}
		return true;
	}
    private List<String>  constructSolution(char[][] board){
		List<String> result =  new ArrayList<>();
		for(int i = 0;i<board.length;i++){
			result.add(new String(board[i]));
		}
		return result;
	}


}

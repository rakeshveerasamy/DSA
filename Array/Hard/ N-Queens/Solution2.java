class Solution {
    public List<List<String>> solveNQueens(int n) {
        QueenSolver qs = new QueenSolver(n);
        return qs.getResult();
    }
}
class QueenSolver{
    private int n;
    private char [][] board;
    private List<List<String>> solution;

    QueenSolver(int n){
        this.n = n;
        this.solution =new ArrayList<>();

        if(isValid()){
            this.board = new char[this.n][this.n];
            for(int i=0;i<this.n;i++){
                Arrays.fill(this.board[i],'.');
            }
            solveQueen(0);

        }
    }

    private boolean isValid(){
            return this.n!=0;
    }

    private void solveQueen(int row){

        if(row == this.n){
            this.solution.add(constructSolution());
            return;
        }

        for(int col = 0;col<this.n;col++){
            if(isValidEntry(row,col)){
                this.board[row][col] = 'Q';
                solveQueen(row+1);
                this.board[row][col] = '.';
            }
        }
        
    }

    private List<String> constructSolution(){
        List<String> result = new ArrayList<>();
        for(int i=0;i<this.n;i++){
            result.add(new String(this.board[i]));
        }
        return result;
    }

    private boolean isValidEntry(int row, int col){
        for(int currrow =0;currrow<this.n;currrow++){
                if(this.board[currrow][col] == 'Q') return false;
        }

        for(int i= row-1,j = col-1;i>=0&&j>=0;i--,j--){
            if(this.board[i][j] == 'Q') return false;
        }

        for(int i= row-1,j=col+1;i>=0 && j<this.n;i--,j++){
            if(this.board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<List<String>> getResult(){
        return this.solution;
    }
}

import java.util.*;

public class Solution {
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.

        NumberOfIsland island = new NumberOfIsland(n,m,q);
        return island.getResult();
    }
}
class DisjointSet{
    private int vertices;
    private List<Integer> parent;
    private List<Integer> size;

    DisjointSet(int vertices){
        this.vertices = vertices;
        this.parent = new ArrayList<>();
        this.size = new ArrayList<>();
        init();
    }

    private void init(){
        
        for(int i=0;i<this.vertices;i++){
            this.parent.add(i);
            this.size.add(1);
        }
    }

    public int findUltimateParent(int node){
        if(this.parent.get(node) == node){
            return node;
        }

        int par = findUltimateParent(this.parent.get(node));
        this.parent.set(node,par);
        return par;
    }

    public void unionBySize(int u, int v){
        int uParent =findUltimateParent(u);
        int vParent = findUltimateParent(v);

        if(uParent ==vParent) return;

        if(this.size.get(uParent)<this.size.get(vParent)){
            this.parent.set(uParent, vParent);
            this.size.set(uParent, this.size.get(uParent)+this.size.get(vParent));
        }
        else{
            this.parent.set(vParent, uParent);
            this.size.set(vParent, this.size.get(uParent)+this.size.get(vParent));
        }
    }
}

class NumberOfIsland{
    private int row;
    private int col;
    private int [][] operations;
    private int[] ans ;

    NumberOfIsland(int row, int col, int [][] operations){
        this.row =row;
        this.col = col;
        this.operations = operations;
        this.ans = new int []{0};

        if(isValid()){
                countNumberOfIsland();
        }
    }

    private boolean isValid(){
        return this.row!=0 && this.col!=0 && this.operations!=null && this.operations.length!=0 && this.operations[0].length ==2;
    }

    private boolean valid(int r, int c){
        return r>=0 && c>=0 && r<this.row && c<this.col ;
    }

    private void countNumberOfIsland(){
         int vertices =this.row*this.col;
         DisjointSet set = new DisjointSet(vertices);

         boolean visited[][] = new boolean [this.row][this.col];
         int cnt =0;
         int  oprSize = this.operations.length;
         int res[] = new int [oprSize];


        for(int i=0;i<oprSize;i++){
                int opRow = this.operations[i][0];
                int opCol = this.operations[i][1];
                int node = (opRow*this.col)+opCol;

                if(visited[opRow][opCol]){
                    res[i] =cnt;
                     continue;
                }

                visited[opRow][opCol] =true;
                cnt++;

                int rDir[] = new int []{-1,0,1,0};
                int cDir []= new int []{0,-1,0,1};

                for(int j=0;j<4;j++){
                    int currRow= opRow+rDir[j];
                    int currCol = opCol +cDir[j];

                    if(valid(currRow,currCol) && visited[currRow][currCol]){
                            int currNode = (currRow*this.col)+currCol;

                            if(set.findUltimateParent(currNode)!=set.findUltimateParent(node)){
                                cnt--;
                                set.unionBySize(currNode, node);
                            }
                    }
                }

                res[i] = cnt;

         }

        this.ans =res;

    }

    public int[] getResult(){
        return this.ans;
    }
}

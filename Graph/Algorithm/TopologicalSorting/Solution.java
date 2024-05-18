class TopologicalSort{
        private ArrayList<ArrayList<Integer>> edges;
        private int vertices;
        private boolean [] visited;
        private Stack<Integer> stk;
        private ArrayList<Integer> res;

        TopologicalSort(ArrayList<ArrayList<Integer>> edges, int vertices){
                this.edges = edges;
                this.vertices  = vertices;
                this.res = new ArrayList<>();

                if(isValid()){
                    this.visited = new boolean[vertices];
                   this.stk = new Stack<>();
                    initiateDFS();   
                }
        }

        private boolean isValid(){
                return this.edges!=null && !this.edges.isEmpty() && this.vertices!=0;
        }

        private void initiateDFS(){
                for(int i=0;i<this.vertices;i++){
                        if(!this.visited[i]){
                                performDFS(i);
                        }
                }

                while(!stk.isEmpty()){
                    this.res.add(stk.pop());
                }
        }

        private void performDFS(int index){
            this.visited[index] = true;
                for(int neighbour : this.edges.get(index)){
                    if(!this.visited[neighbour]){
                        performDFS(neighbour);
                    }
                }
            this.stk.push(index);
        }

        public ArrayList<Integer> getResult(){
                return this.res;
        }
}

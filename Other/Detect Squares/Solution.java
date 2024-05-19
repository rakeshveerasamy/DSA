class DetectSquares {
    List<int[]> coordinates;
    Map<String , Integer> frequencyCounter;

    public DetectSquares() {
            this.coordinates = new ArrayList<>();
            this.frequencyCounter = new HashMap<>();
    }
    
    public void add(int[] point) {
        this.coordinates.add(point);
        int x =point[0];
        int y =point[1];
        String key = x+"@"+y;
        this.frequencyCounter.put(key,this.frequencyCounter.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int sum=0;
        for(int [] coord: this.coordinates){
            int px = coord[0];
            int py=coord[1];

            if(x==px || y==py || (Math.abs(px-x))!=Math.abs(py-y)){
                continue;
            }
            sum+=this.frequencyCounter.getOrDefault(px+"@"+y,0)*this.frequencyCounter.getOrDefault(x+"@"+py,0);
        }
        return sum;
        
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */

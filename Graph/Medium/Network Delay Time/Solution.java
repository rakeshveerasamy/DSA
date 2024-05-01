class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
          int dist[] = new int [n];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[k-1] = 0;

        for(int i = 0;i<n-1;i++){
            for(int[] edge:times){
                int src = edge[0]-1;
                int des= edge[1]-1;
                int wt = edge[2];

                if((dist[src]!=Integer.MAX_VALUE) && ( dist[src]+wt<dist[des])){
                    dist[des] = dist[src]+wt;
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }
}

/*
   Time complexity = O(k*E) k = stop E= edges;
   space complexity = O(n)
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dis[] = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        for(int i = 0; i<k+1; i++) {
            int tempArr[] = Arrays.copyOf(dis,n);
            for(int j = 0; j<flights.length; j++) {
                int u = flights[j][0];
                int v = flights[j][1];
                int wt = flights[j][2];
                if(dis[u] != Integer.MAX_VALUE  && dis[u] + wt < tempArr[v]) {
                    tempArr[v] = dis[u] + wt;
                }
            }
        dis = tempArr;
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}

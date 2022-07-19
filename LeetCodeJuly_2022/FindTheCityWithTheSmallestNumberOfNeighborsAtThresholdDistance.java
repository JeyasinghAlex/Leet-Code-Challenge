import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] ans : edges){
            int u = ans[0];
            int v = ans[1];
            int w = ans[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            dist[i] = dijkstra(adj, distanceThreshold, i, n);
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i< n; ++i){
            if(dist[i] <= min){
                min = dist[i];
                ans = i;
            }
        }
        return ans;
    }


    private int dijkstra(List<int[]>[] adj, int distanceThreshold, int curr, int n){

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{curr,0});
        dist[curr] = 0;

        while(!pq.isEmpty()){

            int[] temp = pq.poll();
            curr = temp[0];
            int wei = temp[1];

            for(int[] next : adj[curr]) {

                int v = next[0];
                int w = next[1];

                if(wei + w < dist[v]){
                    dist[v] = wei + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(dist[i] <= distanceThreshold) {
                ++ans;
            }
        }
        return ans - 1;
    }
}

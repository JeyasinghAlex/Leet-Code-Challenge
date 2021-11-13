import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : roads) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        return dijkstra(graph, n, 0);
    }

    int dijkstra(List<int[]>[] graph, int n, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] ways = new int[n];
        ways[src] = 1;
        dist[src] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0] - b[0]);
        minHeap.offer(new int[]{0, 0});  // dist, src
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], u = top[1];
            for (int[] nei : graph[u]) {
                int v = nei[0], time = nei[1];
                if (dist[v] > d + time) {
                    dist[v] = d + time;
                    ways[v] = ways[u];
                    minHeap.add(new int[]{dist[v], v});
                } else if (dist[v] == d + time) {
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                }
            }
        }
        return ways[n-1];
    }
}

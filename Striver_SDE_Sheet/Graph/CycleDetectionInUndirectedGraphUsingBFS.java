package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphUsingBFS {

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {

            if (!visited[i]) {
                boolean flag = bfs(i, adj, visited);
                if (flag) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean bfs(int curr, List<Integer>[] adj, boolean[] visited) {

        Queue<int[]> qu = new LinkedList<>();
        visited[curr] = true;

        qu.offer(new int[]{curr, -1});

        while (!qu.isEmpty()) {
            int[] temp = qu.poll();
            curr = temp[0];
            int parrent = temp[1];

            for (int v : adj[curr]) {
                if (!visited[v]) {
                    visited[v] = true;
                    qu.offer(new int[]{v, curr});
                }
                else if (v != parrent) {
                    return true;
                }
            }
        }
        return false;
    }
}

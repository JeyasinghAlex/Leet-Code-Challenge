package Graph;

import java.util.*;

/**
 * Is Graph Bipartite?
 */
public class BipartiteCheckUsingBFS {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);


        for (int i = 0; i < n; ++i) {
            for (int v : graph[i]) {
                adj[i].add(v);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                if (!isBipartite(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int curr, int[] color, List<Integer>[] adj) {

        Queue<Integer> qu = new LinkedList<>();
        color[curr] = 1;
        qu.offer(curr);

        while(!qu.isEmpty()) {
            curr = qu.poll();

            for (int v : adj[curr]) {
                if (color[v] == -1) {
                    color[v] = 1 - color[curr];
                    qu.offer(v);
                }
                else if (color[curr] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}

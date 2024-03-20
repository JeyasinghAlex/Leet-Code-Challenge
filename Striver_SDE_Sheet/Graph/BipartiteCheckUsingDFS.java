package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Is Graph Bipartite?
 */
public class BipartiteCheckUsingDFS {

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

        if (color[curr] == -1) {
            color[curr] = 1;
        }

        for (int v : adj[curr]) {
            if (color[v] == -1) {
                color[v] = 1 - color[curr];
                if (!isBipartite(v, color, adj)) {
                    return false;
                }
            }
            else if (color[curr] == color[v]) {
                return false;
            }
        }
        return true;
    }
}

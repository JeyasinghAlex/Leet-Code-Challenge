import java.util.*;

public class BipartiteGraph_GraphColoring_Using_DFS {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        int[] color = new int[n + 1];
        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(color, -1);

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }


        for (int i = 1; i <= n; ++i) {
            if (color[i] == -1) {
                boolean flag = dfs(i, color, adj);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean dfs(int curr, int[] color, List<Integer>[] adj) {

        if (color[curr] == -1) {
            color[curr] = 1;
        }

        for (int v : adj[curr]) {
            if (color[v] == -1) {
                color[v] = 1 - color[curr];
                boolean flag = dfs(v, color, adj);
                if (!flag) {
                    return false;
                }
            } else if (color[curr] == color[v]) {
                return false;
            }
        }
        return true;
    }
}

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
                boolean flag = bfs(i, color, adj);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int curr, int[] color, List<Integer>[] adj) {

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(curr);
        color[curr] = 0;

        while (!qu.isEmpty()) {

            curr = qu.poll();
            for (int v : adj[curr]) {
                if (color[v] == -1) {
                    color[v] = 1 - color[curr];
                    qu.offer(v);
                } else if (color[curr] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}

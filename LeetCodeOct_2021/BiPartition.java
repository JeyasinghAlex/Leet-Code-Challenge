import java.util.*;

public class BiPartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int[] arr : dislikes) {
            int a = arr[0];
            int b = arr[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= n; ++i) {
            if (color[i] == -1) {
                if (!dfs(adj, color, i)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean dfs(List<Integer>[] adj, int[] color, int node) {

        if (color[node] == -1) {
            color[node] = 1;
        }

        for (int next : adj[node]) {
            if (color[next] == -1) {
                color[next] = 1 - color[node];
                if (!dfs(adj, color, next)) {
                    return false;
                }
            } else if (color[next] == color[node]) {
                return false;
            }
        }
        return true;
    }


    public boolean possibleBipartition_bfs(int n, int[][] dislikes) {

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int[] arr : dislikes) {
            int a = arr[0];
            int b = arr[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= n; ++i) {
            if (color[i] == -1) {
                if (!bfs(adj, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(List<Integer>[] adj, int[] color, int node) {

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(node);
        color[node] = 1;

        while (!qu.isEmpty()) {

            int curr = qu.poll();

            for (int next : adj[curr]) {

                if (color[next] == -1) {
                    color[next] = 1 - color[curr];
                    qu.offer(next);
                }
                else if (color[curr] == color[next]) {
                    return false;
                }
            }
        }
        return true;
    }
}

import java.util.Arrays;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {

        int n  = graph.length;

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                if (!isBiPartite(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBiPartite(int curr, int[][] adj, int[] color) {

        if (color[curr] == -1) {
            color[curr] = 1;
        }

        for (int next : adj[curr]) {

            if (color[next] == -1) {
                color[next] = 1 - color[curr];
                if (!isBiPartite(next, adj, color)) {
                    return false;
                }
            } else if (color[next] == color[curr]) {
                return false;
            }
        }
        return true;
    }
}

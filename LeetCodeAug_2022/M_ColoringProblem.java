import java.util.ArrayList;
import java.util.List;

public class M_ColoringProblem {

    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here

        List<Integer>[] adj = new ArrayList[n];
        int[] color = new int[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; ++i) {
            for (int j = 0; j < graph[0].length; ++j) {
                if (graph[i][j]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        if (backtrack(0, adj, color, m, n)) {
            return true;
        }
        return false;
    }

    private boolean isSafe(int node, List<Integer>[] adj, int[] color, int col) {

        for (int v : adj[node]) {
            if (color[v] == col) {
                return false;
            }
        }
        return true;
    }

    private boolean backtrack(int node, List<Integer>[] adj, int[] color, int m, int n) {

        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; ++i) {

            if (isSafe(node, adj, color, i)) {
                color[node] = i;

                if (backtrack(node + 1, adj, color, m, n)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
}

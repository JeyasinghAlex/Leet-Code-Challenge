import java.util.List;

public class BridgesInGraph {

    public void printBridges(int n, List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        int timer = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, -1, timer, visited, tin, low, adj);
            }
        }
    }

    private void dfs(int curr, int parent, int timer, boolean[] visited, int[] tin, int[] low, List<List<Integer>> adj) {

        visited[curr] = true;
        tin[curr] = low[curr] = timer++;

        for (int next : adj.get(curr)) {
            if (next == parent) {
                continue;
            }

            if (!visited[next]) {
                dfs(next, curr, timer, visited, tin, low, adj);
                low[curr] = Math.min(low[curr], low[next]);
                if (low[next] > low[curr]) {
                    System.out.println(next + ": " + curr);
                }
            } else {
                low[curr] = Math.min(low[next], low[next]);
            }
        }
    }
}

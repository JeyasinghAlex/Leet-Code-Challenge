import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {

    public int[] topoSort(int n, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }

        int[] topo = new int[n];
        int idx = 0;
        while (!stack.isEmpty()) {
            topo[idx++] = stack.pop();
        }
        return topo;
    }

    private void dfs(int curr, boolean[] visited, List<Integer>[] adj, Stack<Integer> stack) {

        if (visited[curr]) {
            return;
        }

        visited[curr] = true;
        for (int v : adj[curr]) {
            if (!visited[v]) {
                dfs(v, visited, adj, stack);
            }
        }
        stack.push(curr);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> st = new Stack<>();
        boolean[] visited  = new boolean[V];

        for (int i = 0; i < V; ++i) {

            if (!visited[i]) {
                dfs(i, st, visited, adj);
            }
        }

        int[] topo = new int[V];
        int idx = 0;
        while (!st.isEmpty()) {
            topo[idx++] = st.pop();
        }
        return topo;
    }

    private void dfs(int curr, Stack<Integer> st, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        if (visited[curr]) {
            return ;
        }

        visited[curr] = true;

        for (int v : adj.get(curr)) {
            if (!visited[v]) {
                dfs(v, st, visited, adj);
            }
        }
        st.push(curr);
    }
}

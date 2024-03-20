package Graph;

import java.util.ArrayList;

public class DFSOfGraph {

    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < v; ++i) {
            if (!visited[i]) {
                dfs(i, adj, visited, ans);
            }
        }

        return ans;
    }


    private void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {

        visited[curr] = true;
        ans.add(curr);

        for (int v : adj.get(curr)) {

            if (!visited[v]) {
                dfs(v, adj, visited, ans);
            }
        }
    }
}

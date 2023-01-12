import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {

        List<Integer>[] adj = new ArrayList[n];
        int[] arr = new int[26];
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);

        }

        dfs(0, -1, adj, arr, ans, labels);
        return ans;
    }

    private void dfs(int curr, int parr, List<Integer>[] adj, int[] arr, int[] ans, String labels) {

        char ch = labels.charAt(curr);
        int temp = arr[ch - 'a'];
        arr[ch - 'a'] = 1;

        for (int v : adj[curr]) {
            if (v != parr)
                dfs(v, curr, adj, arr, ans, labels);
        }

        ans[curr] = arr[ch  - 'a'];
        arr[ch - 'a'] += temp;
    }
}

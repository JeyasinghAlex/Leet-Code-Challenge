import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : richer) {
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; ++i) {
            dfs(i, ans, quiet, adj);
        }
        return ans;
    }

    private int dfs(int curr, int[] ans, int[] quiet, List<Integer>[] adj) {

        if (ans[curr] == -1) {

            ans[curr] = curr;
            for (int next : adj[curr]) {
                int a = dfs(next, ans, quiet, adj);
                if (quiet[a] < quiet[ans[curr]]) {
                    ans[curr] = a;
                }
            }
        }
        return ans[curr];
    }
}

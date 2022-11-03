package WeeklyContest_299_26_06_22;

import java.util.ArrayList;
import java.util.List;

public class MinimumScoreAfterRemovalsOnTree {

    private int ans = Integer.MAX_VALUE;
    public int minimumScore(int[] nums, int[][] edges) {

        int n = nums.length;
        List<Integer>[] adj = new ArrayList[n];
        int total = 0;

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
            total ^= nums[i];
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(adj, nums, 0, -1, total);
        return ans;

    }

    private int dfs(List<Integer>[] adj, int[] nums, int src, int par, int total) {

        int myXor = nums[src];
        for (int v : adj[src]) {
            if (v != par) {
                int nbrXor = dfs(adj, nums, v, src, total);
                helper(adj, nums, 0, -1, v, nbrXor, total);
                myXor ^= nbrXor;
            }
        }
        return myXor;
    }

    private int helper(List<Integer>[] adj, int[] nums, int src, int par, int block, int xor1, int total) {

        int myXor = nums[src];
        for (int v : adj[src]) {
            if (v != par && v != block) {
                int nbrXor = helper(adj, nums, v, src, block, xor1, total);
                int xor2 = nbrXor;
                int xor3 = total ^ xor1 ^ xor2;

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));

                this.ans = Math.min(ans, max - min);

                myXor ^= nbrXor;
            }
        }
        return myXor;
    }
}

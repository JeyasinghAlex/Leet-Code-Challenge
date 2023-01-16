package WeeklyContest_328_15_01_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferenceBetweenMaximumAndMinimumPriceSum {

    public long maxOutput(int n, int[][] edges, int[] price) {

        List<Integer>[] adj = new ArrayList[n];
        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        long max = 0l;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, dfs(i, -1, adj, map, price) - price[i]);
        }
        return max;
    }

    private long dfs(int curr, int parr, List<Integer>[] adj, Map<String, Long> map, int[] price) {

        String path = curr + ":" + parr;
        if (map.containsKey(path)) {
            return map.get(path);
        }

        long max = 0l;
        for (int v : adj[curr]) {

            if (v ==  parr) {
                continue;
            }
            max = Math.max(max, dfs(v, curr, adj, map, price));
        }
        map.put(path, max + price[curr]);
        return map.get(path);
    }
}

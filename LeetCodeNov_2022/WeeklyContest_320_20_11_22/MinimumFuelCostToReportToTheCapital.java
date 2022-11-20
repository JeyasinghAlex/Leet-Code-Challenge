package WeeklyContest_320_20_11_22;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {


    public long minimumFuelCost(int[][] roads, int seats) {

        int n = roads.length;
        List<Integer>[] adj = new ArrayList[n + 1];
        int[] parent = new int[n + 1];
        int[] subTreeNodes = new int[n + 1];

        parent[0] = -1;

        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            adj[u].add(v);
            adj[v].add(u);

        }

        countSubTreeNodes(0, adj, parent, subTreeNodes);
        long ans = 0L;
        for (int j = 1; j <= n; j ++) {
            ans += Math.ceil((double)subTreeNodes[j] / seats);
        }
        return ans;
    }

    private int countSubTreeNodes (int src, List<Integer>[] adj, int[] parent, int[] subTreeNodes) {

        int result = subTreeNodes[src];

        for (int child: adj[src]) {
            if (child == parent[src])
                continue;

            parent[child] = src;
            result += countSubTreeNodes(child, adj, parent, subTreeNodes);
        }

        ++result;
        subTreeNodes[src] = result;
        return result;
    }
}

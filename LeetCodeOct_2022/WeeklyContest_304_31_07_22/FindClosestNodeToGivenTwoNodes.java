package WeeklyContest_304_31_07_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            if (edges[i] != -1)
                adj[i].add(edges[i]);
        }

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        arr1[node1] = 0;
        arr2[node2] = 0;

        dfs(adj, arr1, node1, new boolean[n], 1);
        dfs(adj, arr2, node2, new boolean[n], 1);

        int minDis = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; ++i) {

            if (arr1[i] == -1 || arr2[i] == -1) {
                continue;
            }

            int max = Math.max(arr1[i], arr2[i]);

            if (max < minDis) {
                minDis = max;
                ans = i;
            }
        }
        return ans;
    }

    private void dfs(List<Integer>[] adj, int[] arr, int curr, boolean[] visited, int dis) {

        if (visited[curr]) {
            return ;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                arr[v] = dis;
                dfs(adj, arr, v, visited, dis + 1);
            }
        }
    }
}

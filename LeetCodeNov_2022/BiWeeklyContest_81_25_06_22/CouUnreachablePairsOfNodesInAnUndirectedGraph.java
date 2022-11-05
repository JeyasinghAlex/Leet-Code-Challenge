package BiWeeklyContest_81_25_06_22;

import java.util.ArrayList;
import java.util.List;

public class CouUnreachablePairsOfNodesInAnUndirectedGraph {

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = countPairs(i, visited, list);
            sum += count * (n - count);
        }
        return sum / 2;
    }

    private long countPairs(int i, boolean[] visited, List<Integer>[] list) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        int count = 1;
        for (int j : list[i]) {
            count += countPairs(j, visited, list);
        }
        return count;
    }
}

package WeeklyContest_322_04_12_22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumScoreOfPathBetweenTwoCities {

    public int minScore(int n, int[][] roads) {

        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
        }

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        qu.offer(1);
        visited[1] = true;
        int min = Integer.MAX_VALUE;

        while (!qu.isEmpty()) {

            int curr = qu.poll();

            for (int[] arr : adj[curr]) {

                int v = arr[0];
                int d = arr[1];

                if (d < min) {
                    min = d;
                }

                if (!visited[v])
                    qu.offer(v);

                visited[v] = true;
            }
        }
        return min;
    }
}

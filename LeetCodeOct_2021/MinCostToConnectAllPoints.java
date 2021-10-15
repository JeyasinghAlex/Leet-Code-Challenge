import java.util.Arrays;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }

        boolean[] visited = new boolean[n];
        int[] values = new int[n];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;

        for (int i = 0; i < n; ++i) {

            int u = selectMinimumVertex(visited, values);
            visited[u] = true;

            for (int j = 0; j < n; ++j) {
                if (!visited[j]) {
                    values[j] = Math.min(values[j], graph[u][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += values[i];
        }
        return ans;
    }

    private int selectMinimumVertex(boolean[] visited, int[] values) {

        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i] && values[i] < min) {
                min = values[i];
                vertex = i;
            }
        }
        return vertex;
    }
}

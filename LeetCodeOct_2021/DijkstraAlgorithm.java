import java.util.Arrays;

public class DijkstraAlgorithm {

    public void dijkstra(int v, int[][] graph) {

        int[] parent = new int[v];
        int[] value = new int[v];
        Arrays.fill(value, Integer.MAX_VALUE);
        boolean[] visited = new boolean[v];

        parent[0] = -1;
        value[0] = 0;

        for (int i = 0; i < v - 1; ++i) {

            int u = selectMinVertex(visited, value);
            visited[u] = true;

            for (int j = 0; j < v; ++j) {

                if (!visited[j] && graph[u][j] != 0 && value[u] != Integer.MAX_VALUE && value[u] + graph[u][j] < value[j]) {
                    value[j] = value[u] + graph[u][j];
                    parent[j] = u;
                }
            }
        }
    }

    private int selectMinVertex(boolean[] visited, int[] value) {

        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i] && value[i] < min) {
                min = value[i];
                vertex = i;
            }
        }
        return vertex;
    }
}

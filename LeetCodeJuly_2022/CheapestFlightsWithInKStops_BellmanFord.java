import java.util.Arrays;

public class CheapestFlightsWithInKStops_BellmanFord {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        for (int i = 0; i <= k; ++i) {

            int[] values = path.clone();

            for (int[] arr : flights) {
                int u = arr[0];
                int v = arr[1];
                int w = arr[2];

                if (path[u] != Integer.MAX_VALUE && path[u] + w < values[v]) {
                    values[v] = path[u] + w;
                }
            }

            path = values;
        }
        return path[dst] != Integer.MAX_VALUE ? path[dst] : -1;
    }
}

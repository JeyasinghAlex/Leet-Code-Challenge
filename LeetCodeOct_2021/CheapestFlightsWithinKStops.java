import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        for (int i = 0; i <= k; ++i) {

            int[] values = path.clone();

            for (int[] edge : flights) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (path[u] != Integer.MAX_VALUE && path[u] + wt < values[v]) {
                    values[v] = path[u] + wt;
                }
            }
            path = values;
        }
        return path[dst] != Integer.MAX_VALUE ? path[dst] :  -1;
    }

}

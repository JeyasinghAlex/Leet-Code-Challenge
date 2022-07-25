import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSpanningTree_KruskalAlgorithm {

    public void kruskalAlgo(int[][] edges, int n) {

        int[] parent = new int[n];
        int[] rank = new int[n];
        List<int[]> mst = new ArrayList<>();
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        int cost = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u, parent) != find(v, parent)) {
                cost += w;
                mst.add(edge);
                union(u, v, parent, rank);
            }
        }

        for (int[] edge : mst) {
            System.out.println(edge[0] + " - " + edge[1]);
        }
        System.out.println(cost);
    }

    private int find(int u, int[] parent) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(u, parent);
    }

    private void union(int u, int v, int[] parent, int[] rank) {

        u = find(u, parent);
        v = find(v, parent);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if (rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[u] = v;
            rank[v]++;
        }
    }
}

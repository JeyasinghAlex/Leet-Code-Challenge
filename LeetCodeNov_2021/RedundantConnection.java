public class RedundantConnection {

    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int a = find(edge[0]);
            int b = find(edge[1]);
            if (a == b) {
                return edge;
            }
            union(a, b);
        }
        return null;
    }

    private void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if (a != b) {
            parent[b] = a;
        }
    }

    private int find(int v) {

        if (parent[v] == v) {
            return v;
        }
        return find(parent[v]);
    }
}

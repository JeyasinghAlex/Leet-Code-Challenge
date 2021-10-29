import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSet {

    public boolean disjoint(int n, int[][] arr) {

        List<int[]> edgeList = new ArrayList<>();
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int[] edge : arr) {
            edgeList.add(edge);
        }
        return isCyclic(edgeList, parent);
    }

    private boolean isCyclic(List<int[]> edges, int[] parent) {

        for (int[] edge : edges) {
            int a = find(edge[0], parent);
            int b = find(edge[1], parent);

            if (a == b) {
                return true;
            }
            union(a, b, parent);
        }
        return false;
    }

    private void union(int a, int b, int[] parent) {
        parent[a] = b;
    }

    private int find(int v, int[] parent) {
        if (parent[v] == -1) {
            return v;
        }
        return find(parent[v], parent);
    }
}

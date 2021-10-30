import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnionByRankAndPathCompression {

    class Node {
        int parent;
        int rank;
    }

    Node[] dsuf;
    public boolean pathCompression(int n, int[][] arr) {

        dsuf = new Node[n];
        for (int i = 0; i < n; ++i) {
            dsuf[i] = new Node();
        }

        for (int i = 0; i < n; ++i) {
            dsuf[i].parent = -1;
            dsuf[i].rank = 0;
        }

        List<int[]> list = new ArrayList<>();
        for (int[] a : arr) {
            list.add(a);
        }
        return isCyclic(list);
    }

    private boolean isCyclic(List<int[]> edges) {

        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);
            if (a == b) {
                return true;
            }
            union(a, b);
        }
        return false;
    }

    private void union(int fromP, int toP) {

        if (dsuf[fromP].rank > dsuf[toP].rank) {
            dsuf[toP].parent = fromP;
        } else if (dsuf[toP].rank > dsuf[fromP].rank) {
            dsuf[fromP].parent = toP;
        } else {
            dsuf[fromP].parent = dsuf[toP].parent;
            dsuf[toP].rank += 1;
        }
    }

    private int find(int v) {

        if (dsuf[v].parent == -1) {
            return v;
        }
        return dsuf[v].parent = find(dsuf[v].parent);
    }
}

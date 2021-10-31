public class NumberOfProvinces {

    class Node {
        int parent;
        int rank;
    }

    Node[] dsuf;
    int count;
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        count = n;
        dsuf = new Node[n];
        for (int i = 0; i < n; ++i) {
            dsuf[i] = new Node();
        }

        for (int i = 0; i < n; ++i) {
            dsuf[i].parent = i;
        }
        unionFind(isConnected);
        return count;
    }

    private void unionFind(int[][] isConnected) {

        int row = isConnected.length;
        int col = isConnected[0].length;

        for (int i = 0; i < row - 1; ++i) {
            for (int j = i + 1; j < col; ++j) {

                if (isConnected[i][j] == 1) {
                    int a = find(i);
                    int b = find(j);
                    if (a != b) {
                        union(a, b);
                    }
                }
            }
        }
    }

    private void union(int u, int v) {

        if (dsuf[u].rank > dsuf[v].rank) {
            dsuf[v].parent = u;
        } else if (dsuf[v].rank > dsuf[u].rank) {
            dsuf[u].parent = v;
        } else {
            dsuf[u].parent = dsuf[v].parent;
            dsuf[v].rank += 1;
        }
        count--;
    }

    private int find(int v) {

        if (dsuf[v].parent == v) {
            return v;
        }
        return dsuf[v].parent = find(dsuf[v].parent);
    }
}

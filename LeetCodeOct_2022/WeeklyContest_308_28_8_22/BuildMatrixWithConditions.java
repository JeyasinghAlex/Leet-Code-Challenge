package WeeklyContest_308_28_8_22;

import java.util.*;

public class BuildMatrixWithConditions {

    public int[][] buildMatrixUsingKhansAlgo(int k, int[][] rowConditions, int[][] colConditions) {

        int[] rowInDegree = new int[k + 1];
        int[] colInDegree = new int[k + 1];
        List<Integer>[] rowGraph = buildGraph(rowConditions, rowInDegree, k);
        List<Integer>[] colGraph = buildGraph(colConditions, colInDegree, k);

        List<Integer> rowTopo = topoSort(rowGraph, rowInDegree);
        List<Integer> colTopo = topoSort(colGraph, colInDegree);

        if (rowTopo.size() != k || colTopo.size() != k) {
            return new int[0][0];
        }

        int[] topoRow = new int[k];
        int[] topoCol = new int[k];
        for (int i = 0; i < k; ++i) {
            topoRow[i] = rowTopo.get(i);
        }
        for (int i = 0; i < k; ++i) {
            topoCol[i] = colTopo.get(i);
        }

        int[][] ans = constructMatrix(topoRow, topoCol, k);
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Integer>[] rowGraph = buildGraph(rowConditions, k);
        List<Integer>[] colGraph = buildGraph(colConditions, k);

        boolean[] rV = new boolean[k + 1];
        boolean[] dfsRV = new boolean[k + 1];

        boolean[] cV = new boolean[k + 1];
        boolean[] dfsCV = new boolean[k + 1];
        for (int i = 1; i <= k; ++i) {
            if (!rV[i]) {
                boolean isCycle = isCycle(rowGraph, rV, dfsRV, i);
                if (isCycle) {
                    return new int[0][0];
                }
            }
        }

        for (int i = 1; i <= k; ++i) {
            if (!cV[i]) {
                boolean isCycle = isCycle(colGraph, cV, dfsCV, i);
                if (isCycle) {
                    return new int[0][0];
                }
            }
        }

        Stack<Integer> rs = new Stack<>();
        boolean[] rowVisited = new boolean[k + 1];
        for (int i = 1; i <= k; ++i)
            topoSort(rowGraph, rowVisited, rs, i);

        Stack<Integer> cs = new Stack<>();
        boolean[] colVisited = new boolean[k + 1];
        for (int i = 1; i <= k; ++i)
            topoSort(colGraph, colVisited, cs, i);

        int[] topoRow = new int[k];
        int[] topoCol = new int[k];
        int idx = 0;
        while (!rs.isEmpty()) {
            topoRow[idx++] = rs.pop();
        }
        idx = 0;
        while (!cs.isEmpty()) {
            topoCol[idx++] = cs.pop();
        }

        int[][] ans = constructMatrix(topoRow, topoCol, k);
        return ans;
    }


    private int[][] constructMatrix(int[] topoRow, int[] topoCol, int k) {

        int[] row = new int[k + 1];
        int[] col = new int[k + 1];

        for (int i = 0; i < k; ++i) {
            row[topoRow[i]] = i;
            col[topoCol[i]] = i;
        }

        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; ++i) {
            ans[row[i]][col[i]] = i;
        }
        return ans;
    }


    private void topoSort(List<Integer>[] adj, boolean[] visited, Stack<Integer> st, int curr) {

        if (visited[curr]) {
            return;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                topoSort(adj, visited, st, v);
            }
        }
        st.push(curr);
    }

    private boolean isCycle(List<Integer>[] adj, boolean[] visited, boolean[] dfsvisited, int curr) {

        if (visited[curr]) {
            return true;
        }

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                boolean flag = isCycle(adj, visited, dfsvisited, v);
                if (flag) {
                    return true;
                }
            } else if (dfsvisited[v]) {
                return true;
            }
        }
        dfsvisited[curr] = false;
        return false;
    }

    private List<Integer>[] buildGraph(int[][] edges, int n) {

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
        }
        return adj;
    }


    private List<Integer> topoSort(List<Integer>[] adj, int[] inDegree) {

        Queue<Integer> qu = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for (int i = 1; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            topo.add(curr);

            for (int v : adj[curr]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    qu.offer(v);
                }
            }
        }
        return topo;
    }

    private List<Integer>[] buildGraph(int[][] edges, int[] inDegree, int n) {

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);

            inDegree[v]++;
        }
        return adj;
    }
}

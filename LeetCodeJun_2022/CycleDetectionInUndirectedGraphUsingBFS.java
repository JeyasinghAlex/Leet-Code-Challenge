import java.util.*;

public class CycleDetectionInUndirectedGraphUsingBFS {

    public boolean isCycle(int v, List<List<Integer>> adj) {

        boolean[] visited = new boolean[v + 1];
        for (int i = 1; i <= v; ++i) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean bfs(int vertex, boolean[] visited, List<List<Integer>> adj) {

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{vertex, -1});
        visited[vertex] = true;

        while (!qu.isEmpty()) {
            int[] temp = qu.poll();
            int curr = temp[0];
            int parent = temp[1];
            for (int v : adj.get(curr)) {
                if (!visited[v]) {
                    visited[v] = true;
                    qu.offer(new int[]{v, curr});
                } else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}

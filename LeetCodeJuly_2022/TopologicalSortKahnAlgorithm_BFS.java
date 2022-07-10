import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahnAlgorithm_BFS {

    public int[] topoSort(int n, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[n];
        int[] inDegree = new int[n];
        Queue<Integer> qu = new LinkedList<>();
        int[] topo = new int[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);

            inDegree[v]++;
        }

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                qu.offer(i);
            }
        }

        int idx = 0;
        while (!qu.isEmpty()) {

            int curr = qu.poll();
            topo[idx++] = curr;

            for (int v : adj[curr]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    qu.offer(v);
                }
            }
        }
        return topo;
    }
}

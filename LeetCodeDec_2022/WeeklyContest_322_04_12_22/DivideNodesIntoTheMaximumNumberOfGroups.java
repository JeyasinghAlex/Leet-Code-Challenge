package WeeklyContest_322_04_12_22;

import java.util.*;

public class DivideNodesIntoTheMaximumNumberOfGroups {

    public int magnificentSets(int N, int[][] edges) {
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                List<Integer> list = new ArrayList<>();
                while (!q.isEmpty()) {
                    int u = q.poll();
                    list.add(u);
                    for (int v : adj[u]) {
                        if (!visited[v]) {
                            q.offer(v);
                            visited[v] = true;
                        }
                    }
                }
                int max = 0;
                j: for (int j : list) {
                    q = new LinkedList<>();
                    int[] dist = new int[N];
                    Arrays.fill(dist, -1);
                    dist[j] = 0;
                    q.offer(j);
                    while (!q.isEmpty()) {
                        int u = q.poll();
                        for (int v : adj[u]) {
                            if (dist[v] == -1) {
                                dist[v] = dist[u] + 1;
                                q.offer(v);
                            }
                        }
                    }
                    for (int k : list) {
                        for (int l : adj[k]) {
                            if (Math.abs(dist[k] - dist[l]) != 1) {
                                continue j;
                            }
                        }
                    }
                    for (int k : list) {
                        max = Math.max(max, dist[k] + 1);
                    }
                }
                if (max == 0) {
                    return -1;
                }
                res += max;
            }
        }
        return res;
    }
}

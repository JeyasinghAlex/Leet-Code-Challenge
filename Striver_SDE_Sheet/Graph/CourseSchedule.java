package Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        boolean[] dfsvisited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (isCycle(i, adj, visited, dfsvisited)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean isCycle(int curr, List<Integer>[] adj, boolean[] visited, boolean[] dfsvisited) {

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                if (isCycle(v, adj, visited, dfsvisited)) {
                    return true;
                }
            }
            else if (dfsvisited[v]){
                return true;
            }
        }

        dfsvisited[curr] = false;
        return false;
    }
}

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Course Schedule II
 */
public class TopologicalSortDFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsvisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj[v].add(u);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                if (isCycle(i, visited, dfsvisited, adj)) {
                    return new int[]{};
                }
            }
        }

        Arrays.fill(visited, false);
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                topoSort(i, visited, adj, st);
            }
        }

        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    private void topoSort(int curr, boolean[] visited, List<Integer>[] adj, Stack<Integer> st) {

        visited[curr] = true;
        for (int v : adj[curr]) {
            if (!visited[v]) {
                topoSort(v, visited, adj, st);
            }
        }
        st.push(curr);
    }

    private boolean isCycle(int curr, boolean[] visited, boolean[] dfsvisited, List<Integer>[] adj) {

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                if(isCycle(v, visited, dfsvisited, adj)) {
                    return true;
                }
            }
            else if (dfsvisited[v]) {
                return true;
            }
        }

        dfsvisited[curr] = false;
        return false;
    }
}

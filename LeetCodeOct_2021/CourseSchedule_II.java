import java.util.*;

public class CourseSchedule_II {

    public int[] findOrder_1(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> st = new LinkedList<>();

        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }

        boolean isCycle = isCycle(numCourses, adj);

        if (isCycle) {
            return new int[]{};
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                topologicalSort(i, st, adj, visited);
            }
        }

        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.poll();
        }
        return ans;
    }

    private void topologicalSort(int curr, Queue<Integer> st, List<Integer>[] adj, boolean[] visited) {

        if (visited[curr]) {
            return ;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {

            if (!visited[v]) {
                topologicalSort(v, st, adj, visited);
            }
        }
        st.offer(curr);
    }


    private boolean isCycle(int n, List<Integer>[] adj) {

        boolean[] visited = new boolean[n];
        boolean[] dfsvisited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                boolean flag = isCycleUtil(i, adj, visited, dfsvisited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleUtil(int curr, List<Integer>[] adj, boolean[] visited, boolean[] dfsvisited) {

        if (visited[curr]) {
            return true;
        }

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {

            if (!visited[v]) {
                boolean flag = isCycleUtil(v, adj, visited, dfsvisited);
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

    public int[] findOrder(int n, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        boolean[] dfsvisited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
        }


        //Using Topological Sort
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                boolean flag = isCycle(i, visited, dfsvisited, adj, st);
                if (flag) {
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[n];
        int idx = 0;
        while(!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }



    private boolean isCycle(int curr, boolean[] visited, boolean[] dfsvisited, List<Integer>[] adj, Stack<Integer> st) {

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {

            if (!visited[v]) {
                if (isCycle(v, visited, dfsvisited, adj, st)) {
                    return true;
                }
            } else if (dfsvisited[v]) {
                return true;
            }
        }

        st.push(curr);
        dfsvisited[curr] = false;
        return false;
    }
}

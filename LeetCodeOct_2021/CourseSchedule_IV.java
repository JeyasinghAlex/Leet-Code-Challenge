import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule_IV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Integer>[] adj = new ArrayList[numCourses];
        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < queries.length; ++i) {
            int[] querie = queries[i];
            Arrays.fill(visited, false);
            boolean flag = dfs(querie[0], querie[1], visited, adj);
            if (flag) {
                ans[i] = true;
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (boolean a : ans) {
            res.add(a);
        }
        return res;
    }

    private boolean dfs(int curr, int target, boolean[] visited, List<Integer>[] adj) {

        if (curr == target) {
            return true;
        }

        if (visited[curr]) {
            return false;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {
            boolean flag = dfs(v, target, visited, adj);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}

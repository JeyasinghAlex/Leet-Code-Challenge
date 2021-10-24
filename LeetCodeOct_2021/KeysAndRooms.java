import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            List<Integer> list = rooms.get(i);
            for (int a : list) {
                adj[i].add(a);
            }
        }

        boolean[] visited = new boolean[n];
        dfs(0, visited, adj);

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int curr, boolean[] visited, List<Integer>[] adj) {

        if (visited[curr]) {
            return ;
        }

        visited[curr] = true;

        for (int next : adj[curr]) {
            dfs(next, visited, adj);
        }
    }
}

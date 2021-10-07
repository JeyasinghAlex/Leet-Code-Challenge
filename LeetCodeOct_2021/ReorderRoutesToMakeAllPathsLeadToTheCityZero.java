import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public int minReorder(int n, int[][] connections) {

        List<Integer>[] adj = new ArrayList[n];
        List<Integer>[] back = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        int ans = 0;
        qu.offer(0);
        for (int[] path : connections) {
            adj[path[0]].add(path[1]);
            back[path[1]].add(path[0]);
        }

        while (!qu.isEmpty()) {
            int curr = qu.poll();
            visited[curr] = true;

            for (int a : adj[curr]) {
                if (!visited[a]) {
                    ++ans;
                    qu.offer(a);
                }
            }
            for (int b : back[curr]) {
                if (!visited[b]) {
                    qu.offer(b);
                }
            }
        }
        return ans;
    }
}

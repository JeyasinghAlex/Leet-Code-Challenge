import java.util.*;

public class DFS_Graph {

    public List<Integer> bfsOfGraph(int v, List<List<Integer>> adj) {

        boolean[] visited = new boolean[v + 1];
        List<Integer> bfs = new ArrayList<>();

        for (int i = 1; i <= v; ++i) {

            if (!visited[i]) {
                Queue<Integer> qu = new LinkedList<>();
                qu.add(i);
                visited[i] = true;

                while (!qu.isEmpty()) {
                    int vertex = qu.poll();
                    bfs.add(vertex);
                    for (int num : adj.get(vertex)) {
                        if (!visited[num]) {
                            visited[num] = true;
                            qu.add(num);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}

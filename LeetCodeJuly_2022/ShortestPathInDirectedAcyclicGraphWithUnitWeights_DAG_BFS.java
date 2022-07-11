import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraphWithUnitWeights_DAG_BFS {

    class Pair {
        private int v;
        private int weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return this.v;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    public int[] shortestPath(int n, int src, int[][] prerequisites) {

        int r = prerequisites.length;
        int c = prerequisites[0].length;

        List<Pair>[] adj = new ArrayList[n];
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (prerequisites[i][j] != 0) {
                    adj[i].add(new Pair(j, prerequisites[i][j]));
                }
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                topoSort(i, visited, adj, stack);
            }
        }

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (dist[curr] != Integer.MAX_VALUE) {
                for (Pair pair : adj[curr]) {
                    int v = pair.getV();
                    int weight = pair.getWeight();
                    if (dist[curr] + weight < dist[v]) {
                        dist[v] = dist[curr] + weight;
                    }
                }
            }
        }
        return dist;
    }

    private void topoSort(int curr, boolean[] visited, List<Pair>[] adj, Stack<Integer> stack) {

        if (visited[curr]) {
            return ;
        }
        visited[curr] = true;

        for (Pair pair : adj[curr]) {

            if (!visited[pair.getV()]) {
                topoSort(pair.getV(), visited, adj, stack);
            }
        }
        stack.push(curr);
    }
}

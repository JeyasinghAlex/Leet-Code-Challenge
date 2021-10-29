import java.util.*;

public class PossibleBiPartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        int[] colour = new int[n + 1];
        Arrays.fill(colour, -1);

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= n; ++i) {
            if (colour[i] == -1) {
                if (!isBiPartition(adj, colour, i, n)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBiPartition(List<Integer>[] adj, int[] colour, int node, int n) {

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(node);
        colour[node] = 1;

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            for (int next : adj[curr]) {

                if (colour[next] == colour[curr]) {
                    return false;
                }
                if (colour[next] == -1) {
                    colour[next] = 1 - colour[curr];
                    qu.offer(next);
                }
            }
        }
        return true;
    }
}

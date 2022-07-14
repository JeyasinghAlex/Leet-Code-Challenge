import java.util.*;

public class PathWithMaximumProbability {

    class Pair {

        int v;
        double w;
        public Pair(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<double[]>[] adj = new ArrayList[n];
        double[] dist = new double[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MIN_VALUE);

        int idx = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            double w = succProb[idx++];

            adj[u].add(new double[]{v, w});
            adj[v].add(new double[]{u, w});
        }

        Queue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {

            public int compare(Pair a, Pair b) {
                if (a.w > b.w) {
                    return -1;
                }
                return 1;
            }
        });

        dist[start] = 1;
        qu.offer(new Pair(start, 0));

        while(!qu.isEmpty()) {

            Pair temp = qu.poll();
            int curr = temp.v;
            double weight = temp.w;

            for (double[] next : adj[curr]) {

                int v = (int) next[0];
                double w = next[1];

                if (dist[curr] * w > dist[v]) {
                    dist[v] = dist[curr] * w;
                    qu.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist[end] != Integer.MIN_VALUE ? dist[end] : 0;
    }
}

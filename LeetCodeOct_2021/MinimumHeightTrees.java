import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        if (n == 0) {
            return list;
        }

        if (n == 1) {
            list.add(0);
            return list;
        }

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        int[] level = new int[n];
        Queue<Integer> qu = new LinkedList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            level[edge[0]]++;
            level[edge[1]]++;
        }

        for (int i = 0; i < n; ++i) {
            if (level[i] == 1) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {

            int len = qu.size();
            ans = new ArrayList<>();
            while (len-- > 0) {

                int temp = qu.poll();
                ans.add(temp);
                for (int a : adj[temp]) {
                    level[a]--;
                    if (level[a] == 1) {
                        qu.offer(a);
                    }
                }
            }
        }
        return ans;
    }
}

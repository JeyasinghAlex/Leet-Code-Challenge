package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule II
 */
public class TopologicalSortBFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inOrder = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            inOrder[u]++;

            adj[v].add(u);
        }

        if (!topoSort(inOrder, adj, list)) {
            return new int[]{};
        }

        for (int i = 0; i < numCourses; ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private boolean topoSort(int[] inOrder, List<Integer>[] adj, List<Integer> list) {

        Queue<Integer> qu = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < inOrder.length; ++i) {
            if (inOrder[i] == 0) {
                list.add(i);
                qu.offer(i);
                ++count;
            }
        }

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            for (int v : adj[curr]) {
                inOrder[v]--;

                if (inOrder[v] == 0) {
                    list.add(v);
                    qu.offer(v);
                    ++count;
                }
            }
        }
        return count == inOrder.length;
    }
}

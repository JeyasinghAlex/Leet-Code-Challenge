package LeetCode_2024;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        if (n == 1) {
            return 0;
        }
        Queue<int[]> qu = new LinkedList<>();
        int finalState = (1 << n) - 1;
        boolean[][] visited = new boolean[n][finalState + 1];
        for (int i = 0; i < n; ++i) {
            qu.offer(new int[]{i, 1 << i});
        }

        int shortestPath = 0;
        while (!qu.isEmpty()) {
            int len = qu.size();
            ++shortestPath;
            while (len-- > 0) {
                int[] arr = qu.poll();
                int node = arr[0];
                int nodeBitState = arr[1];

                for (int neighbor : graph[node]) {
                    int newNodeBitState = nodeBitState | (1 << neighbor);

                    if (visited[neighbor][newNodeBitState]) {
                        continue;
                    }
                    visited[neighbor][newNodeBitState] = true;
                    if (newNodeBitState == finalState) {
                        return shortestPath;
                    }
                    qu.offer(new int[]{neighbor, newNodeBitState});
                }
            }

        }
        return -1;
    }
}

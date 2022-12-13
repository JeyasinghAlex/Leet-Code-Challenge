package WeeklyContest_323_11_12_22;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfPointsFromGridQueries {

    public int[] maxPoints(int[][] grid, int[] queries) {

        int n = queries.length;
        int[] ans = new int[n];
        int[][] queriesVsIndex = new int[n][2];
        for (int i = 0; i < n; ++i) {
            queriesVsIndex[i][0] = queries[i];
            queriesVsIndex[i][1] = i;
        }

        Arrays.sort(queriesVsIndex, (a, b) -> a[0] - b[0]);

        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        for (int i = 0; i < n; ++i) {
            int val = queriesVsIndex[i][0];
            int idx = queriesVsIndex[i][1];

            while (!pq.isEmpty() && pq.peek()[2] < val) {
                int[] arr = pq.poll();
                ++cnt;

                for (int[] d : dir) {
                    int r = arr[0] + d[0];
                    int c = arr[1] + d[1];

                    if (r >= 0 && r < row && c >= 0 && c < col && !visited[r][c]) {
                        visited[r][c] = true;
                        pq.offer(new int[]{r, c, grid[r][c]});
                    }
                }
            }
            ans[idx] = cnt;
        }
        return ans;
    }
}

package WeeklyContest_295_29_05_22;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumObstacleRemovalToReachCorner {

    public int minimumObstacles(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, 0});

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[row][col];

        for (int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int currCost = arr[2];

            if (r == row - 1 && c == col - 1) {
                return currCost;
            }

            for (int[] d : dir) {
                int x = r + d[0];
                int y = c + d[1];

                if (x < 0 || x >= row || y < 0 || y >= col) {
                    continue;
                }

                int newCost = grid[x][y] == 1 ? currCost + 1 : currCost;

                if (newCost < cost[x][y]) {
                    pq.offer(new int[]{x, y, newCost});
                    cost[x][y] = newCost;
                }
            }
        }
        return -1;
    }
}

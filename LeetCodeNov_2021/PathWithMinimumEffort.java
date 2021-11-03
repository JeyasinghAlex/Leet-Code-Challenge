import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;
        int[][] cost = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        qu.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!qu.isEmpty()) {

            int[] curr = qu.poll();
            int a = curr[0];
            int b = curr[1];
            visited[a][b] = true;

            if (a == row - 1 && b == col - 1) {
                return curr[2];
            }

            for (int[] d : dir) {
                int x = a + d[0];
                int y = b + d[1];
                int currCost =  curr[2];

                if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) {
                    continue;
                }

                int diff = Math.abs(heights[a][b] - heights[x][y]);
                int maxDiff = Math.max(currCost, diff);

                if (maxDiff < cost[x][y]) {
                    cost[x][y] = maxDiff;
                    qu.offer(new int[]{x, y, cost[x][y]});
                }
            }
        }
        return cost[row - 1][col - 1];
    }
}

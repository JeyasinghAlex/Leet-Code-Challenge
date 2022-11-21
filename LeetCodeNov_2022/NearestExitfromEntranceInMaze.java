import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {

        int row = maze.length;
        int col = maze[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;

        while (!qu.isEmpty()) {

            ++step;
            int len = qu.size();
            while (len-- > 0) {

                int[] curr = qu.poll();
                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (x < 0 || x >= row || y < 0 || y >= col) {
                        continue;
                    }
                    if (maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == row - 1 || y == 0 || y == col - 1) {
                        return step;
                    }
                    maze[x][y] = '+';
                    qu.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}

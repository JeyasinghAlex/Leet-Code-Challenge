import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][][] visited = new boolean[row][col][k + 1];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {

                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r== row - 1 && c == col-1){
                    return res;
                }
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR>=0 && nextR< row && nextC>=0 && nextC<col){
                        if(grid[nextR][nextC]==1){
                            nextK++;
                        }
                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }
            ++res;
        }
        return -1;
    }
}

package WeeklyContest_292_08_05_22;

import java.util.Stack;

public class CheckIfThereIsValidParenthesesStringPath {

    public boolean hasValidPath(char[][] grid) {

        boolean[][][] visited = new boolean[101][101][101];
        return dfs(0, 0, 0, grid, visited);
    }

    private boolean dfs(int r, int c, int bal, char[][] grid, boolean[][][] visited) {


        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }

        bal += grid[r][c] == '(' ? 1 : -1;

        if (bal == 0 && r == grid.length - 1 && c == grid[0].length - 1) {
            return true;
        }
        if (bal < 0 || (bal > (grid.length + grid[0].length) / 2) || visited[r][c][bal]) {
            return false;
        }

        visited[r][c][bal] = true;
        return dfs(r + 1, c, bal, grid, visited) || dfs(r, c + 1, bal, grid, visited);

    }
}

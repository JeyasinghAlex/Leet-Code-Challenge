package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public List<String> findPath(int[][] m, int n) {
        // Your code here
        List<String> ans = new ArrayList<>();
        backtrack(0, 0, "", m, ans);
        return ans;
    }

    private void backtrack(int r, int c, String s, int[][] nums, List<String> list) {

        if (r < 0 || c < 0 || r >= nums.length || c >= nums[0].length || nums[r][c] != 1) {
            return ;
        }

        if (r == nums.length - 1 && c == nums[0].length - 1) {
            list.add(s);
            return ;
        }

        nums[r][c] = 2;
        backtrack(r + 1, c, s + 'D', nums, list);
        backtrack(r - 1, c, s + 'U', nums, list);
        backtrack(r, c + 1, s + 'R', nums, list);
        backtrack(r, c - 1, s + 'L', nums, list);
        nums[r][c] = 1;
    }


    public List<String> findPath_dfs(int[][] m, int n) {
        // Your code here

        List<String> ans = new ArrayList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if (m[0][0] == 1) {
            backtrack(m, 0, 0, "", dir, ans);
        }
        return ans;
    }


    private void backtrack(int[][] path, int r, int c, String s, int[][] dir, List<String> ans) {

        if (r == path.length - 1 && c == path[0].length - 1) {
            ans.add(s);
            return ;
        }

        String direction = "DURL";
        for (int i = 0; i < 4; ++i) {
            int[] d = dir[i];
            int nextR = r + d[0];
            int nextC = c + d[1];

            if (nextR >= 0 && nextR < path.length && nextC >= 0 && nextC < path[0].length && path[nextR][nextC] == 1) {
                path[r][c] = 2;
                backtrack(path, nextR, nextC, s + direction.charAt(i), dir, ans);
                path[r][c] = 1;
            }
        }
    }

    public static ArrayList<String> findPath_1(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        dfs(0, 0, "", m, visited, ans);
        return ans;
    }

    private static void dfs(int r, int c, String s, int[][] nums, boolean[][] visited, List<String> list) {

        if (r < 0 || c < 0 || r >= nums.length || c >= nums[0].length || nums[r][c] == 0 || visited[r][c]) {
            return ;
        }

        if (r == nums.length - 1 && c == nums[0].length - 1) {
            list.add(s);
            return ;
        }

        visited[r][c] = true;
        dfs(r + 1, c, s + 'D', nums, visited, list);
        dfs(r - 1, c, s + 'U', nums, visited, list);
        dfs(r, c + 1, s + 'R', nums, visited, list);
        dfs(r, c - 1, s + 'L', nums, visited, list);
        visited[r][c] = false;
    }
}

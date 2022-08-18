import java.util.ArrayList;
import java.util.List;

public class RatInMazeAllPaths {

    public List<String> findPath(int[][] m, int n) {
        // Your code here
        List<String> ans = new ArrayList<>();
        dfs(0, 0, "", m, ans);
        return ans;
    }

    private void dfs(int r, int c, String s, int[][] nums, List<String> list) {

        if (r < 0 || c < 0 || r >= nums.length || c >= nums[0].length || nums[r][c] != 1) {
            return ;
        }

        if (r == nums.length - 1 && c == nums[0].length - 1) {
            list.add(s);
            return ;
        }

        nums[r][c] = 2;
        dfs(r + 1, c, s + 'D', nums, list);
        dfs(r - 1, c, s + 'U', nums, list);
        dfs(r, c + 1, s + 'R', nums, list);
        dfs(r, c - 1, s + 'L', nums, list);
        nums[r][c] = 1;
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

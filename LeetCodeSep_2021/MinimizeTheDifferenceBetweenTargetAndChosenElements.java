public class MinimizeTheDifferenceBetweenTargetAndChosenElements {

    public int minimizeTheDifference(int[][] mat, int target) {

        Integer[][] dp = new Integer[mat.length][5001];
        return minDiff(mat, 0, 0, target, dp);
    }

    private int minDiff(int[][] mat, int r, int val, int target, Integer[][] dp) {

        if (r == mat.length) {
            return Math.abs(val - target);
        }

        if (dp[r][val] != null) {
            return dp[r][val];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; ++i) {

            int temp = minDiff(mat, r + 1, val + mat[r][i], target, dp);
            res = Math.min(res, temp);
        }

        dp[r][val] = res;
        return res;
    }
}

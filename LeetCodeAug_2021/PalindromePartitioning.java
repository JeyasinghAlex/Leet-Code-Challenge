import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }
        for (int i = 2; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {

                int k = i + j;
                if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, ans, new ArrayList<>(), dp, s, "");
        return ans;
    }


    private void backtrack(int start, List<List<String>> ans, List<String> list, boolean[][] dp, String s, String sub) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = start; i < s.length(); ++i) {

            if (dp[start][i]) {
                String substring = s.substring(start, i + 1);
                list.add(substring);
                backtrack(i + 1, ans, list, dp, s, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition_1(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(ans, list, 0, s);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> list, int start, String s) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = start; i < s.length(); ++i) {

            boolean isPalindrome = isPalindrome(s, start, i);
            if (isPalindrome) {
                String subString = substring(s, start, i);
                list.add(subString);
                dfs(ans, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private String substring(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i; --j;
        }
        return true;
    }
}

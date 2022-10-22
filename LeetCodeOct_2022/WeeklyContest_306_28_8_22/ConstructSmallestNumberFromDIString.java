package WeeklyContest_306_28_8_22;

public class ConstructSmallestNumberFromDIString {

    public String smallestNumber(String pattern) {

        int n = pattern.length();
        boolean[] visited = new boolean[10];
        backtrack(pattern, "", 0, visited);
        return ans;
    }

    String ans = "9999999999";

    private void backtrack(String pattern, String s, int idx, boolean[] visited) {

        if (s.compareTo(ans) > 0) {
            return;
        }

        if (s.length() == pattern.length() + 1) {
            boolean isValid = isValid(pattern, s);
            if (isValid) {
                if (s.compareTo(ans) < 0) {
                    ans = s;
                }
            }
            return ;
        }

        for (int i = 1; i <= 9; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(pattern, s + i, idx + 1, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isValid(String pattern, String s) {

        int n = pattern.length();
        for (int i = 0; i < n; ++i) {
            if (pattern.charAt(i) == 'I' && s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
            if (pattern.charAt(i) == 'D' && s.charAt(i) < s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

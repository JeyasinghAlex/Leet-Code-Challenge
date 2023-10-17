package Recursion;

public class PermutationSequence {

    private int cnt;
    public String getPermutation(int n, int k) {

        boolean[] visited  = new boolean[n + 1];
        return helper(visited, n, k, "");
    }

    private String helper(boolean[] visited, int n, int k, String s) {

        if (s.length() == n) {
            ++cnt;

            if (cnt == k)
                return s;
        }


        for (int i = 1; i <= n; ++i) {

            if (!visited[i]) {
                visited[i] = true;
                String seq = helper(visited, n, k, s + i);
                if (seq.length() > 0)
                    return seq;

                visited[i] = false;
            }
        }
        return "";
    }
}

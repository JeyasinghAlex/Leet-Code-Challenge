import java.util.Arrays;

public class LongestRepeatingSubsequence {

    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] lrs = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    lrs[i][j] = 1 + lrs[i - 1][j - 1];
                } else {
                    lrs[i][j] = Math.max(lrs[i - 1][j], lrs[i][j - 1]);
                }
            }
        }
//        return lrs[n][n];
        int m = n;
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (str.charAt(m - 1) == str.charAt(n - 1) && m != n) {
                sb.append(str.charAt(m - 1));
                m--;
                n--;
            } else {
                if (lrs[m - 1][n] > lrs[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
        return lrs[str.length()][str.length()];
    }

    public String LongestRepeatingSubsequence_1(String str) {

        int n = str.length();
        String[][] lrs = new String[n + 1][n + 1];
        for (String[] arr : lrs) {
            Arrays.fill(arr, "");
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j ) {
                    lrs[i][j] = lrs[i - 1][j - 1] + str.charAt(i - 1);
                } else {
                    lrs[i][j] = lrs[i - 1][j].length() > lrs[i][j - 1].length() ? lrs[i - 1][j] : lrs[i][j - 1];
                }
            }
        }
        return lrs[n][n];
    }
}

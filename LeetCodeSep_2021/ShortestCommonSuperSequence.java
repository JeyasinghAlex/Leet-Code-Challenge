import java.util.Arrays;

public class ShortestCommonSuperSequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] =  1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int l = m + n - lcs[m][n];

        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {

            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                sb.append(str1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (lcs[m - 1][n] > lcs[m][n - 1]) {
                    sb.append(str1.charAt(m - 1));
                    m--;
                } else {
                    sb.append(str2.charAt(n - 1));
                    n--;
                }
            }
        }

        while (m > 0) {
            sb.append(str1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(str2.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }


    public String shortestCommonSupersequence_1(String str1, String str2) {

        String lcs = lcs(str1, str2);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        for (char ch : lcs.toCharArray()) {

            while (str1.charAt(i) != ch) {
                sb.append(str1.charAt(i));
                ++i;
            }
            while (str2.charAt(j) != ch) {
                sb.append(str2.charAt(j));
                ++j;
            }
            sb.append(ch);
            ++i;
            ++j;
        }

        return sb.toString() + str1.substring(i) + str2.substring(j);

    }

    private String lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        String[][] lcs = new String[m + 1][n + 1];
        for (String[] s : lcs) {
            Arrays.fill(s, "");
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    lcs[i][j] = lcs[i][j -1].length() > lcs[i - 1][j].length() ? lcs[i][j - 1] : lcs[i - 1][j];
                }
            }
        }
        return lcs[m][n];
    }
}

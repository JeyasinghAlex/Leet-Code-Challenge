public class KMP {

    public int maxRepeating(String sequence, String word) {

        int[] lps = new int[word.length() + 1];
        char[] pat = word.toCharArray();
        computeLps(lps, pat);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < sequence.length()) {
            if (pat[j] == sequence.charAt(i)) {
                ++i;
                ++j;
            } else {
                if (j != 0)  {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }

            if (j == word.length()) {
                ++count;
                j = lps[j - 1];
            }
        }
        return count;
    }

    private void computeLps(int[] lps, char[] pat) {

        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < pat.length) {

            if (pat[i] == pat[len]) {
                lps[i] = len + 1;
                len += 1;
                i += 1;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
    }
}

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {

        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            int upper = 0, lower = 0;
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    lower = lower | (1 << (s.charAt(j) - 'a'));
                } else {
                    upper = upper | (1 << (s.charAt(j) - 'A'));
                }
                if (lower == upper && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

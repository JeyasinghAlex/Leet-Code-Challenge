public class IncreasingDecreasingString {

    public String sortString(String s) {

        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < s.length()) {

            for (int i = 0; i < 26; ++i) {
                if (cnt[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                    ++j;
                }
            }

            for (int i = 25; i >= 0; --i) {
                if (cnt[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                    ++j;
                }
            }
        }
        return sb.toString();
    }
}

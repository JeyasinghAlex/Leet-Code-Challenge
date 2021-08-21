public class CustomSortString {

    public String customSortString(String order, String s) {

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while (freq[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }

        for (int i = 0; i < 26; ++i) {
            while (freq[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
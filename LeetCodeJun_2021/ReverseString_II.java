public class ReverseString_II {

    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k ) {

            int l = i;
            int r = Math.min(i + k - 1, s.length() - 1);
            while (l < r) {
                char ch = chars[l];
                chars[l] = chars[r];
                chars[r] = ch;
                ++l; --r;
            }
        }
        return new String(chars);
    }
}

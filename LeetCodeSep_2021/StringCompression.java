public class StringCompression {

    public int compress(char[] chars) {

        int count = 0;
        char ch = chars[0];
        int idx = 0;
        for (int i = 0; i <= chars.length; ++i) {

            if (i < chars.length && ch == chars[i]) {
                ++count;
            } else if (i == chars.length || ch != chars[i] ){

                chars[idx++] = ch;
                if (i < chars.length) {
                    ch = chars[i--];
                }
                String str = count + "";
                for (int j = 0; j < str.length() && count > 1; ++j) {
                    chars[idx++] = str.charAt(j);
                }
                count = 0;
            }
        }
        return idx;
    }
}

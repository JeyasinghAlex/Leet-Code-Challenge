package LeetCodeMay_2021;

public class StringCompression {

    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < chars.length) {
            char ch = chars[i];
            while (j < chars.length && chars[i] == chars[j]) {
                ++j;
            }
            int freq = j - i;
            chars[index++] = ch;
            if (freq != 1) {
                for (char c : String.valueOf(freq).toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}

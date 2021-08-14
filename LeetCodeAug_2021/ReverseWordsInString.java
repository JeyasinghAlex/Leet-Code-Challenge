public class ReverseWordsInString {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s);

        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        for (int i = 1; i < sb.length(); ++i) {
            if (sb.charAt(i) == ' ' && sb.charAt(i) == sb.charAt(i - 1)) {
                sb.deleteCharAt(i);
                --i;
            }
        }

        char[] chars = sb.toString().toCharArray();
        reverse(chars, 0, sb.length() - 1);
        int point = 0;
        for (int i = 0; i < sb.length(); ++i) {
            if (chars[i] == ' ') {
                reverse(chars, point, i - 1);
                point = i + 1;
            }
            if (i == sb.length() - 1) {
                reverse(chars, point, i);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {

        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}

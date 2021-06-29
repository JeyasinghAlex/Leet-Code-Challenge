public class ReverseWordsInString_III {

    public String reverseWords(String s) {

        int point = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {

            if (i == s.length() - 1) {
                sb.append(' ');
            }
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                for (int j = i; j >= point; --j) {
                    sb.append(s.charAt(j));
                }
                point = i + 1;
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}

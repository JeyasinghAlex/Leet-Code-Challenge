public class TruncateSentence {

    public String truncateSentence(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

            if (ch == ' ') {

                if (--k == 0) {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }
        return sb.toString();
    }

    public String truncateSentence_1(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int word = 0;
        while (i < s.length()) {
            word++;
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i++));
            }

            if (word == k) {
                return sb.toString();
            }
            sb.append(' ');
            ++i;
        }
        return "";
    }
}

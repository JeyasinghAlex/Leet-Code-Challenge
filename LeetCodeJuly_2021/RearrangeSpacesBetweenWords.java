public class RearrangeSpacesBetweenWords {


    public String reorderSpaces(String text) {

        int spaces = 0;
        int wordCount = 0;

        int i = 0;
        while (i < text.length()) {

            while (i < text.length() && text.charAt(i) == ' ') {
                spaces += 1;
                ++i;
            }

            if (i == text.length()) break;

            while (i < text.length() && text.charAt(i) != ' ') {
                ++i;
            }
            wordCount++;
        }
        wordCount -= 1;
        if (wordCount == 0) wordCount = 1;
        int need = spaces / wordCount;
        i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < text.length()) {
            int extra = need;
            while (i < text.length() && text.charAt(i) == ' ') {
                ++i;
            }

            while (i < text.length() && text.charAt(i) != ' ') {
                sb.append(text.charAt(i++));
            }

            if (i == text.length()) break;


            while (spaces > 0 && extra-- > 0) {
                spaces--;
                sb.append(' ');
            }
        }

        while (spaces-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }
}

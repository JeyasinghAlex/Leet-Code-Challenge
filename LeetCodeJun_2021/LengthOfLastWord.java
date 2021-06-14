public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        int count = 0;
        int i = 0;
        for (i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }

        for ( ; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                break;
            }
            ++count;
        }
        return count;
    }
}

public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {

        int bitMask = 0, count = words.length;
        for (char ch : allowed.toCharArray()) {
            bitMask = bitMask | (1 << (ch - 'a'));
        }

        for (String s : words) {
            for (char ch : s.toCharArray()) {

                if ((bitMask & (1 << (ch - 'a'))) == 0) {
                    --count;
                    break;
                }
            }
        }
        return count;
    }
}

public class DetermineStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);
        return calculateVowelsCount(firstHalf) == calculateVowelsCount(secondHalf);
    }

    private int calculateVowelsCount(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

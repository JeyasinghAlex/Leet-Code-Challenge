public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        int upper = 0;
        int lower = 0;
        for (char ch : word.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ++upper;
            }
        }
        return upper == 0 || upper == word.length() || upper == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
    }

    public boolean detectCapitalUse_1(String word) {

        int upper = 0;
        int lower = 0;
        for (char ch : word.toCharArray()) {

            if (ch >= 'A' && ch <= 'Z') {
                ++upper;
            } else if (ch >= 'a' && ch <= 'z') {
                ++lower;
            }
        }
        if (upper == word.length() || lower == word.length()) {
            return true;
        }
        if (upper > 1) {
            return false;
        }

        return word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
    }
}

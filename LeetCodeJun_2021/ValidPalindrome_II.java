public class ValidPalindrome_II {

    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s.substring(i, j)) || isValid(s.substring(i + 1, j + 1));
            }
            ++i; --j;
        }
        return true;
    }

    private boolean isValid(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i; --j;
        }
        return true;
    }
}

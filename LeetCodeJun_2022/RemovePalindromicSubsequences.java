public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = s.length();
        while (i < j) {
            if (s.charAt(i) != s.charAt(j - 1)) {
                return 2;
            }
            ++i;
            --j;
        }
        return 1;
    }
}

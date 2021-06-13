public class ImplementStrStr {

    public int strStr_1(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        int len = needle.length();

        for (int i = 0; i <= haystack.length() - len; ++i) {

            if (needle.equals(haystack.substring(i, i + len))) {
                return i;
            }
        }
        return -1;
    }

    public int strStr_2(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}
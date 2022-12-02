package WeeklyContest_321_27_11_22;

public class AppendCharactersToStringToMakeSubSequence {

    public int appendCharacters(String s, String t) {

        int i = 0;
        for (char ch : s.toCharArray()) {

            if (i == t.length()) {
                return 0;
            }
            if (ch == t.charAt(i)) {
                ++i;
            }
        }
        return t.length() - i;
    }

    public int appendCharacters_1(String s, String t) {

        int i = -1;
        int j = -1;
        int m = s.length();
        int n = t.length();

        while (i < n && j < m) {

            ++i;
            ++j;

            while (i < n && j < m && t.charAt(i) != s.charAt(j)) {
                ++j;
            }
        }
        return n - i;
    }
}

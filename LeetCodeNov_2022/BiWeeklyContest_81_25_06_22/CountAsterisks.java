package BiWeeklyContest_81_25_06_22;

public class CountAsterisks {

    public int countAsterisks(String s) {

        int n = s.length();
        int cnt = 0;

        int bar = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '*' && bar % 2 == 0)
                ++cnt;

            if (ch == '|')
                ++bar;
        }
        return cnt;
    }

    public int countAsterisks_1(String s) {

        int n = s.length();

        int i = 0;

        int cnt = 0;
        while (i < n) {

            while (i < n && s.charAt(i) != '|') {
                if (s.charAt(i) == '*') {
                    ++cnt;
                }
                ++i;
            }
            ++i;
            while (i < n && s.charAt(i) != '|') {
                ++i;
            }
            ++i;
        }
        return cnt;
    }
}

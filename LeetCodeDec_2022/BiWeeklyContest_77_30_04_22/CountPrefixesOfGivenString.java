package BiWeeklyContest_77_30_04_22;

public class CountPrefixesOfGivenString {

    public int countPrefixes(String[] words, String s) {

        int ans = 0;
        for (String word : words) {
            ans += check(word, s) ? 1 : 0;
        }
        return ans;
    }

    private boolean check(String a, String b) {
        int i = 0;
        int j = 0;

        if (a.length() > b.length()) {
            return false;
        }

        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
            ++i;
        }
        return true;
    }
}

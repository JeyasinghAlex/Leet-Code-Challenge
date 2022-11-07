package WeeklyContest_298_19_06_22;

public class GreatestEnglishLetterInUpperAndLowerCase {

    public String greatestLetter(String s) {

        int[] lower = new int[26];
        int[] upper = new int[26];

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a']++;
            }
            else {
                upper[ch - 'A']++;
            }
        }

        for (int i = 25; i >= 0; --i) {
            if (lower[i] > 0 && upper[i] > 0) {
                return (char) ('A' + i) + "";
            }
        }
        return "";
    }
}

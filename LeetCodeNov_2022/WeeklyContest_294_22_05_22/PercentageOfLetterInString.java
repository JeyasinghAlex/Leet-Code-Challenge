package WeeklyContest_294_22_05_22;

public class PercentageOfLetterInString {

    public int percentageLetter(String s, char letter) {

        int n = s.length();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                ++cnt;
            }
        }
        return (cnt * 100 / n);
    }
}

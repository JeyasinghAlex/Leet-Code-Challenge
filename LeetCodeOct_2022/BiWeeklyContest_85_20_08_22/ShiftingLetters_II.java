package BiWeeklyContest_85_20_08_22;

public class ShiftingLetters_II {

    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();

        int[] letters = new int[n];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i)
            letters[i] = s.charAt(i) - 'a';

        for (int[] shift : shifts) {
            int st = shift[0];
            int ed = shift[1];
            int dir = shift[2];

            sum[st] += dir == 1 ? 1 : -1;
            sum[ed + 1] += dir == 1 ? -1 : 1;
        }

        for (int i = 1; i <= n; ++i)
            sum[i] += sum[i - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int temp = (letters[i] + sum[i]) % 26;
            if (temp < 0)
                temp += 26;
            sb.append((char) (temp + 'a'));
        }
        return sb.toString();
    }
}

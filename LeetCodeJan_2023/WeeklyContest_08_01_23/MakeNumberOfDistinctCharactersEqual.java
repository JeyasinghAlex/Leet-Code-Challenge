package WeeklyContest_08_01_23;

public class MakeNumberOfDistinctCharactersEqual {

    public boolean isItPossible(String word1, String word2) {


        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray())
            freq1[ch - 'a']++;

        for (char ch : word2.toCharArray())
            freq2[ch - 'a']++;

        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {

                if (freq1[i] > 0 && freq2[j] > 0) {
                    freq1[i]--;
                    freq2[j]--;

                    freq1[j]++;
                    freq2[i]++;

                    if (check(freq1, freq2))
                        return true;

                    freq1[i]++;
                    freq2[j]++;

                    freq1[j]--;
                    freq2[i]--;

                }
            }
        }
        return false;
    }

    private boolean check(int[] a, int[] b) {

        int f1 = 0;
        int f2 = 0;

        for (int i = 0; i < 26; ++i) {
            if (a[i] > 0)
                ++f1;

            if (b[i] > 0)
                ++f2;
        }

        return f1 == f2;
    }
}

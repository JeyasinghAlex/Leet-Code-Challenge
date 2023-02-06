package WeeklyContest_331_05_02_23;

public class CountVowelStringsInRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] cnt = new int[n];
        String vowels = "aeiou";

        for (int i = 0; i < n; ++i) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }

            int l = word.length();
            if (vowels.indexOf(word.charAt(0)) >= 0 && vowels.indexOf(word.charAt(l - 1)) >= 0) {
                cnt[i] = 1;
            }
        }

        for (int i = 1; i < n; ++i) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {

            int[] querie = queries[i];
            int start = querie[0];
            int end = querie[1];

            if (start == 0) {
                ans[i] = cnt[end];
            } else {
                ans[i] = cnt[end] - cnt[start - 1];
            }
        }
        return ans;
    }
}

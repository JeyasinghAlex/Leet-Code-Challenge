package WeeklyContest_324_18_12_22;

public class CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {

        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            boolean[] arr1 = pair(words[i]);
            for (int j = i + 1; j < n; ++j) {
                boolean[] arr2 = pair(words[j]);

                if (check(arr1, arr2)) {
                    ++ans;
                }

            }
        }
        return ans;
    }

    private boolean check(boolean[] arr1, boolean[] arr2) {
        for (int i = 0; i < 26; ++i) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    private boolean[] pair(String s) {
        boolean[] arr = new boolean[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a'] = true;
        }
        return arr;
    }
}

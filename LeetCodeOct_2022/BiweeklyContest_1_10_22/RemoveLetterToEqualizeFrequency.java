package BiweeklyContest_1_10_22;

public class RemoveLetterToEqualizeFrequency {

    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < freq.length; ++i) {
            if (freq[i] != 0) {
                freq[i]--;
                if (check(freq)) {
                    return true;
                }
                freq[i]++;
            }
        }
        return false;
    }

    private boolean check(int[] freq) {

        int target = 0;
        for (int i = 0; i < freq.length; ++i) {

            if (freq[i] != 0) {
                target = freq[i];
                break;
            }
        }

        for (int i = 0; i < freq.length; ++i) {
            if (freq[i] != 0 && freq[i] != target) {
                return false;
            }
        }
        return true;
    }
}

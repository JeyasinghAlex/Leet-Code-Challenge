import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int n = word1.length();
        for (int i = 0; i < n; ++i) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            freq1[ch1 - 'a']++;
            freq2[ch2 - 'a']++;
        }


        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != 0 && freq2[i] == 0 || freq1[i] == 0 && freq2[i] != 0) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}

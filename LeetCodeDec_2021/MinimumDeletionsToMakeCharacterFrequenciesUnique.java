import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            int count = freq[i];
            while (count > 0 && !set.add(count)) {
                --count;
                ++ans;
            }
        }
        return ans;
    }

    public int minDeletions_1(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (freq[i] != 0) {
                int count = freq[i];
                while (count > 0) {
                    if (!set.contains(count)) {
                        set.add(count);
                        break;
                    }
                    --count;
                    ++ans;
                }
            }
        }
        return ans;
    }
}

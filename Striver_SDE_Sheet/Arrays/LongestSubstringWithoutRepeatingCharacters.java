package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int idx = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            while (set.contains(ch))
                set.remove(s.charAt(idx++));

            set.add(ch);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public int lengthOfLongestSubstring_1(String s) {

        int n = s.length();
        int[] freq = new int[128];
        int start = 0;
        int end = 0;
        int cnt = 0;
        int max = 0;

        while (end < n) {
            char ch = s.charAt(end);
            freq[ch]++;

            if (freq[ch] > 1)
                cnt++;

            while (cnt > 0) {
                ch = s.charAt(start);
                if (freq[ch] > 1)
                    --cnt;

                freq[ch]--;
                ++start;
            }
            ++end;
            max = Math.max(max, end - start);
        }
        return max;
    }
}

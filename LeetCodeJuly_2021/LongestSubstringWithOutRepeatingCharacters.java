import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithOutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int[] map = new int[128];
        int counter = 0;
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            map[c1]++;
            if (map[c1] > 1) {
                ++counter;
            }
            ++end;

            while (counter > 0) {
                char c2 = s.charAt(start);
                if (map[c2] > 1) {
                    --counter;
                }
                map[c2]--;
                ++start;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public int lengthOfLongestSubstring_1(String s) {

        Set<Character> set = new HashSet<>();
        int max = 0;
        int a = 0;
        int b = 0;
        while (a < s.length()) {

            if (set.add(s.charAt(a))) {
                ++a;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(b++));
            }
        }
        return max;
    }
}

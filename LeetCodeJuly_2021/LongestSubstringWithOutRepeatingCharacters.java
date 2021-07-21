import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithOutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

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

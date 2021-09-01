import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {

            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            if (end - start + 1 - maxFreq > k) {
                char startCh = s.charAt(start++);
                map.put(startCh, map.get(startCh) - 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            ++end;
        }
        return maxLen;
    }
}

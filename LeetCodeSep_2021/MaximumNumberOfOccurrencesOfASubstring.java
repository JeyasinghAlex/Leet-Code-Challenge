import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfOccurrencesOfASubstring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - minSize + 1; ++i) {
            String str = s.substring(i, i + minSize);
            if (isValid(str, maxLetters, minSize)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
                max = Math.max(max, map.get(str));
            }
        }
        return max;
    }

    private boolean isValid(String str, int maxLetters, int minSize) {

        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        return set.size() <= maxLetters && set.size() <= minSize;
    }
}

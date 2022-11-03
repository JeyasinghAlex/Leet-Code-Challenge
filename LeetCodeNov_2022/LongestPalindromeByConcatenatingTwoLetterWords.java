import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            String reverse = "" + word.charAt(1) + word.charAt(0);
            if (map.containsKey(reverse)) {
                ans += 4;
                map.put(reverse, map.get(reverse) - 1);
                if (map.get(reverse) == 0) {
                    map.remove(reverse);
                }
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}

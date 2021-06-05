package weekly_25_4_21;

import java.util.*;

public class LongestSubstringOfAllVowelsOrder {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringOfAllVowelsOrder().longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }
    public int longestBeautifulSubstring(String word) {

        List<Character> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++count;
            } else {
                key.add(word.charAt(i - 1));
                value.add(count);
                count = 1;
            }
        }
        key.add(word.charAt(word.length() - 1));
        value.add(count);

        int max = 1;
        int ans = 0;
        for (int i = 0; i < key.size() - 4; ++i) {
            if (key.get(i) == 'a' && key.get(i + 1) == 'e' && key.get(i + 2) == 'i' && key.get(i + 3) == 'o' && key.get(i + 4) == 'u') {
                ans = value.get(i) + value.get(i + 1) + value.get(i + 2) + value.get(i + 3) +  value.get(i + 4);
            }
            max = Math.max(ans, max);
        }
        return max;
    }
}

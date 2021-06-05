package LeetCodeMay_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {

        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); ++i) {
                String s = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, dp.getOrDefault(s, 0) + 1);
            }
            dp.put(word, max);
            res = Math.max(res, max);
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {

        s1 = s1 + " " + s2;

        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }

    public String[] uncommonFromSentences_1(String s1, String s2) {

        String[] sent1 = s1.split(" ");
        String[] sent2 = s2.split(" ");
        int len = Math.max(sent1.length, sent2.length);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {

            if (i < sent1.length) {
                map.put(sent1[i], map.getOrDefault(sent1[i], 0) + 1);
            }
            if (i < sent2.length) {
                map.put(sent2[i], map.getOrDefault(sent2[i], 0) + 1);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}

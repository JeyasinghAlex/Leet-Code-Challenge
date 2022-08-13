import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {

    public static void main(String[] args) {

        String[] words = {"foo", "bar"};
        String s = "barfoothefoobarman";
        System.out.println(new SubStringWithConcatenationOfAllWords().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();

        int wordLen = words[0].length();
        int wordsLen = words.length;
        int totalLen = wordLen * wordsLen;

        Map<String, Integer> dp = new HashMap<>();

        for (String word : words) {
            dp.put(word, dp.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i <= s.length() - totalLen; ++i) {

            Map<String, Integer> map = new HashMap<>(dp);

            String substr = s.substring(i, i + totalLen);

            for (int j = 0; j <= totalLen - wordLen; j = j + wordLen) {

                String sub = substr.substring(j, j + wordLen);

                if (!map.containsKey(sub)) {
                    break;
                }

                int val = map.get(sub) - 1;

                if (val == 0) {
                    map.remove(sub);
                } else {
                    map.put(sub, val);
                }
            }

            if (map.isEmpty()) {
                list.add(i);
            }
        }
        return list;
    }
}

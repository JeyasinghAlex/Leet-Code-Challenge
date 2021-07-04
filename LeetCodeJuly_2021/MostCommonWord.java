import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        StringBuilder sb = new StringBuilder();
        for (char ch : paragraph.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == ' ') {
                sb.append(ch);
            }
            if (ch == ',') {
                sb.append(' ');
            }
        }

        paragraph = sb.toString();
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : banned) {
            map.remove(word.toLowerCase());
        }

        int max = 0;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }
}

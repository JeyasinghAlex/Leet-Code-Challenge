import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isMatch(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }


    private boolean isMatch(String p, String s) {

        for (int i = 0; i < s.length(); ++i) {
            if (p.indexOf(p.charAt(i)) != s.indexOf(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public List<String> findAndReplacePattern_1(String[] words, String pattern) {

        List<String> ans = new ArrayList<>();
        String p = createPattern(pattern);
        for (String word : words) {
            String s = createPattern(word);
            if (p.equals(s)) {
                ans.add(word);
            }
        }
        return ans;
    }


    private String createPattern(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, i++);
            }
            sb.append(map.get(ch));
        }
        return sb.toString();
    }
}

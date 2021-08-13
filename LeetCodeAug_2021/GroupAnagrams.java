import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            String temp = sort(strs[i]);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String str) {

        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}

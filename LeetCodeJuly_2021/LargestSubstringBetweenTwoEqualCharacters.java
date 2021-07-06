import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        int max = -1;
        for (List<Integer> list : map.values()) {
            if (list.size() > 1) {
                max = Math.max(max, list.get(list.size() - 1) - list.get(0) - 1);
            }
        }
        return max;
    }
}

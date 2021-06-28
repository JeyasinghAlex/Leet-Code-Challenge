import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        return findPattern(s).equals(findPattern(t));
    }

    private String findPattern(String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (char ch : s.toCharArray()) {

            map.putIfAbsent(ch, count++);
            sb.append(map.get(ch));

        }
        return sb.toString();
    }
}

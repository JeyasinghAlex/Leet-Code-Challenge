import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (cnt[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_1(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

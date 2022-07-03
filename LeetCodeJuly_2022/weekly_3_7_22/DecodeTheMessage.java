package weekly_3_7_22;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {

        Map<Character, Character> map = new HashMap<>();
        char val = 'a';

        for (char ch : key.toCharArray()) {
            if (!map.containsKey(ch) && ch != ' ') {
                map.put(ch, val++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                sb.append(ch);
            } else {
                sb.append(map.get(ch));
            }
        }
        return sb.toString();
    }
}

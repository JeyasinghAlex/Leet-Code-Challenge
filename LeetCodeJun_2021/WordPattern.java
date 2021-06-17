import java.util.HashMap;
import java.util.Map;

public class WordPattern {


    public boolean wordPattern(String pattern, String s) {

        String[] str= s.split(" ");

        if (str.length != pattern.length()) {
            return false;
        }

        Map map = new HashMap<>();

        for (Integer i = 0; i < pattern.length(); ++i) {

            if (map.put(pattern.charAt(i), i) != map.put(str[i], i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern_2(String pattern, String s) {

        Map<Character,String> map = new HashMap<>();
        String[] str = s.split(" ");

        if (pattern.length() != str.length) {
            return false;
        }


        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);

            if (map.containsKey(ch)) {

                if (!map.get(ch).equals(str[i])) {
                    return false;
                }

            } else {

                if (map.containsValue(str[i])) {
                    return false;
                }
                map.put(ch, str[i]);
            }
        }

        return true;
    }

    public boolean wordPattern_3(String pattern, String s) {

        Map<Character,Integer> map = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();

        String[] str = s.split(" ");
        if (str.length > pattern.length()) {
            return false;
        }

        StringBuilder patt = new StringBuilder();
        int count = 0;
        for (char ch : pattern.toCharArray()) {

            if (map.containsKey(ch)) {
                patt.append(map.get(ch));
            } else {
                patt.append(count);
                map.put(ch, count++);
            }
        }

        count = 0;
        StringBuilder ans = new StringBuilder();
        for (String st : str) {

            if (sMap.containsKey(st)) {
                ans.append(sMap.get(st));
            } else {
                ans.append(count);
                sMap.put(st, count++);
            }
        }
        return patt.toString().equals(ans.toString());
    }
}

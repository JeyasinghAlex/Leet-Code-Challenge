package LeetCodeMay_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        pattern = findPattern(pattern);
        List<String> list = new ArrayList<>();
        for (String str : words) {
            String s = findPattern(str);
            if (pattern.equals(s)) {
                list.add(str);
            }
        }
        return list;
    }

    private String findPattern(String s) {
        int count = 1;
        StringBuilder pat = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, count++);
            pat.append(map.get(ch));
        }
        return pat.toString();
    }

}

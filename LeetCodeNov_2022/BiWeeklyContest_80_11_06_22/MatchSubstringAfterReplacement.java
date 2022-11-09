package BiWeeklyContest_80_11_06_22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchSubstringAfterReplacement {

    public boolean matchReplacement(String s, String sub, char[][] mappings) {

        if (s.length() < sub.length()) {
            return false;
        }

        int slen = s.length();
        int sublen = sub.length();

        Map<Character, Set<Character>> map = new HashMap<>();


        for (char[] m : mappings) {
            char old = m[0];
            char nw = m[1];

            map.putIfAbsent(old, new HashSet<>());
            map.get(old).add(nw);
        }

        for (int i = 0; i <= slen - sublen; ++i) {
            if (isMatch(s.substring(i, i + sublen), sub, map)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String s, String sub, Map<Character, Set<Character>> map) {

        for (int i = 0; i < sub.length(); ++i) {
            char sch = s.charAt(i);
            char subch = sub.charAt(i);

            if (sch == subch) {
                continue;
            }

            if (!map.containsKey(subch)) {
                return false;
            }

            if (!map.get(subch).contains(sch)) {
                return false;
            }
        }
        return true;
    }
}

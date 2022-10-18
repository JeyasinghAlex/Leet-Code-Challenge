package WeeklyContest_309_4_09_22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDistancesBetweenSameLetters {

    public boolean checkDistances(String s, int[] distance) {

        int n = s.length();

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        for (char ch : map.keySet()) {

            char key = ch;
            List<Integer> values = map.get(ch);
            int dis = distance[ch - 'a'];

            int v1 = values.get(0);
            int v2 = values.get(1);

            if (Math.abs(v2 - v1 - 1) != dis) {
                return false;
            }
        }
        return true;
    }
}

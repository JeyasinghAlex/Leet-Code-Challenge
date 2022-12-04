package WeeklyContest_322_04_12_22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DividePlayersIntoTeamsOfEqualSkill {

    public long dividePlayers(int[] skill) {

        int n = skill.length;
        int group = n / 2;
        long ans = 0l;
        long sum = 0;

        for (int s : skill) {
            sum += s;
        }

        if (sum % group != 0) {
            return -1;
        }
        Arrays.sort(skill);
        int part = (int) sum / group;

        for (int i = 0; i < group; ++i) {
            if (skill[i] + skill[n - i - 1] != part) {
                return -1;
            }
            ans += ((long) skill[i] * skill[n - i - 1]);
        }
        return ans;
    }

    public long dividePlayers_1(int[] skill) {

        int n = skill.length;
        int group = n / 2;
        long ans = 0l;
        long sum = 0;
        for (int s : skill) {
            sum += s;
        }

        if (sum % 2 != 0 && group % 2 == 0) {
            return -1;
        }

        int part = (int) sum / group;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int g = 0;
        for (int sk : skill) {
            if (map.containsKey(part - sk)) {
                ans += ((long) sk * (part - sk));
                int val = map.get(part - sk) - 1;
                map.put(part - sk, val);
                if (val == 0) {
                    map.remove(part - sk);
                }
                ++g;
                continue;
            }
            map.put(sk, map.getOrDefault(sk, 0) + 1);
        }
        return g == group ? ans : -1;
    }
}

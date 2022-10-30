package BiWeeklyContest_83_23_07_22;

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {

        int n = ranks.length;

        Map<Integer, Integer> map = new HashMap<>();

        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) {
            return "Flush";
        }

        for (int i = 0; i < n; ++i) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
        }

        for (int num : map.values()) {
            if (num >= 3) {
                return "Three of a Kind";
            }
        }
        for (int num : map.values()) {
            if (num >= 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}

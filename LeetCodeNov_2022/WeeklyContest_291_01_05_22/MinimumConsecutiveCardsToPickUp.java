package WeeklyContest_291_01_05_22;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {

    public int minimumCardPickup(int[] cards) {

        int n = cards.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {

            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

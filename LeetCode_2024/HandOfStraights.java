package LeetCode_2024;

import java.util.*;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);
        for (int i = 0; i < n; ++i) {

            if (map.get(hand[i]) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; ++j) {
                int currCard = hand[i] + j;

                if (map.get(currCard) == null || map.get(currCard) == 0) {
                    return false;
                }

                map.put(currCard, map.get(currCard) - 1);
            }
        }
        return true;
    }

    public boolean isNStraightHand_1(int[] hand, int groupSize) {

        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Queue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(hand[i])) {
                pq.offer(hand[i]);
            }
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!pq.isEmpty()) {
            int currCard = pq.peek();
            int min = Integer.MAX_VALUE;
            for (int card = currCard; card < currCard + groupSize; ++card) {

                if (pq.isEmpty() || pq.peek() != card) {
                    return false;
                }
                min = Math.min(min, map.get(card));
                pq.poll();
            }

            for (int card = currCard; card < currCard + groupSize; ++card) {
                int val = map.get(card);
                map.put(card, val - min);
                if (val - min > 0) {
                    pq.offer(card);
                }
            }
        }
        return true;
    }
}

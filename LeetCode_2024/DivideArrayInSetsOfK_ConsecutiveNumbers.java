package LeetCode_2024;

import java.util.*;

public class DivideArrayInSetsOfK_ConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {

            if (map.get(nums[i]) == 0) {
                continue;
            }

            for (int j = 0; j < k; ++j) {

                int card = nums[i] + j;
                if (map.get(card) == null || map.get(card) == 0) {
                    return false;
                }
                map.put(card, map.get(card) - 1);
            }
        }
        return true;
    }

    public boolean isPossibleDivide_1(int[] nums, int k) {

        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(nums[i])) {
                pq.offer(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while (!pq.isEmpty()) {
            int currCard = pq.peek();
            int min = Integer.MAX_VALUE;

            for (int card = currCard; card < currCard + k; ++card) {

                if (pq.isEmpty() || pq.peek() != card) {
                    return false;
                }
                min = Math.min(min, map.get(card));
                pq.poll();
            }

            for (int card = currCard; card < currCard + k; ++card) {
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

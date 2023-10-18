package Heaps;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int key : map.keySet()) {
            pq.offer(new int[]{map.get(key), key});

            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty())
            ans[idx++] = pq.poll()[1];

        return ans;
    }
}
